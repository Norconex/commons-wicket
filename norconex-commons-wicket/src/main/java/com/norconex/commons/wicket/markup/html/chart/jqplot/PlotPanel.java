package com.norconex.commons.wicket.markup.html.chart.jqplot;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.AxisOptions;
import com.norconex.commons.wicket.markup.html.panel.CssPanel;

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
