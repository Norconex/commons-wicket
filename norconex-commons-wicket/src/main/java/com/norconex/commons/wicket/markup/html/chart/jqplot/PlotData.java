package com.norconex.commons.wicket.markup.html.chart.jqplot;

import java.io.Serializable;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.PlotOptions;

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
        this.series = series;
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
