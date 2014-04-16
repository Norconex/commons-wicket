package com.norconex.commons.wicket.markup.html.chart.jqplot;

import java.io.Serializable;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.PlotOptions;

public class PlotData implements Serializable {

    private static final long serialVersionUID = -4413727062129022847L;

    private Series<?,?>[] series;
    private PlotOptions options;
    
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

}
