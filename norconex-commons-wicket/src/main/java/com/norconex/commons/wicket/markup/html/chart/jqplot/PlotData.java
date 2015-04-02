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

import java.io.Serializable;

import org.apache.commons.lang3.ArrayUtils;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.PlotOptions;

/**
 * Plot data for JQPlot.
 * @author Pascal Essiembre
 */
public class PlotData implements Serializable {

    private static final long serialVersionUID = -4413727062129022847L;

    private Series<?,?>[] series;
    private PlotOptions options;
    private String preJavascript;
    private String postJavascript;
    
    public PlotData() {
        super();
    }
    public PlotData(PlotOptions options, Series<?,?>... series) {
        super();
        this.options = options;
        this.series = series;
    }
    
    public Series<?,?>[] getSeries() {
        return series;
    }
    public void setSeries(Series<?,?>[] series) {
        this.series = ArrayUtils.clone(series);
    }
    public PlotOptions getOptions() {
        return options;
    }
    public void setOptions(PlotOptions options) {
        this.options = options;
    }
    public String getPreJavascript() {
        return preJavascript;
    }
    public void setPreJavascript(String preJavascript) {
        this.preJavascript = preJavascript;
    }
    public String getPostJavascript() {
        return postJavascript;
    }
    public void setPostJavascript(String postJavascript) {
        this.postJavascript = postJavascript;
    }
}
