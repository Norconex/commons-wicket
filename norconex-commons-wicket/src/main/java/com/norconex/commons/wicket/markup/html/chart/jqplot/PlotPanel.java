/* Copyright 2012-2014 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.commons.wicket.markup.html.chart.jqplot;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.AxisOptions;
import com.norconex.commons.wicket.markup.html.panel.CssPanel;

/**
 * A wicket {@link Panel} displaying a JQPlot.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class PlotPanel extends CssPanel {

    private static final long serialVersionUID = 2590357379506352631L;

    public PlotPanel(String id, PlotData plotData) {
        this(id, plotData, false);
    }
    public PlotPanel(String id, PlotData plotData, boolean minified) {
        super(id);
        setOutputMarkupId(true);

        WebMarkupContainer plotDiv = new WebMarkupContainer("plot");
        plotDiv.setOutputMarkupId(true);
        add(plotDiv);
        String plotId = plotDiv.getMarkupId();

        //XXX hack to get minified version should be done better
        if (minified) {
            AxisOptions xaxis = plotData.getOptions().getAxes().getXaxis();
            Integer val = xaxis.getNumberTicks();
            int numberTicks = 0;
            if (val != null) {
                numberTicks = val;
            }
            if (numberTicks > 0) {
                numberTicks = (int) Math.ceil((float) numberTicks / 2f);
            }
            xaxis.setNumberTicks(numberTicks);
        }

        String code = "";
        if (plotData != null) {
            //--- Options ---
            String options = "{}";
            if (plotData.getOptions() != null) {
                options = plotData.getOptions().toString();
            }
            //--- Series ---
            String series = "[]";
            if (plotData.getSeries() != null) {
                series = "[" + StringUtils.join(
                        plotData.getSeries(), ", ") + "]";
            }
            //--- pre/post JS ---
            String preJs = plotData.getPreJavascript();
            if (preJs == null) {
                preJs = StringUtils.EMPTY;
            }
            String postJs = plotData.getPostJavascript();
            if (postJs == null) {
                postJs = StringUtils.EMPTY;
            }

            //--- Plot Code ---
            code = "$(document).ready(function(){"
                 + preJs   
                 + "  $.jqplot.config.enablePlugins = true;"
                 + "  var plot = $.jqplot('" 
                         + plotId + "', " + series + ", " + options + ");"
                 + "  $(window).resize(function() {"
                 + "    if (plot) { "
                 + "      $.each(plot.series, function(index, series) {"
                 + "        series.barWidth = undefined;"
                 + "      });"
                 + "      plot.replot();"
                 + "    }"
                 + "  });"
                 + postJs
                 + "});";
        }
        Label script = new Label("script", code); 
        script.setEscapeModelStrings(false);
        addOrReplace(script);
    }

}
