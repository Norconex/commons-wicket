package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class Axes implements Serializable {

    private static final long serialVersionUID = -6421729329151316971L;

    private final AxisOptions xaxis = new AxisOptions();
    private final AxisOptions yaxis = new AxisOptions();
    private final AxisOptions x2axis = new AxisOptions();
    private final AxisOptions y2axis = new AxisOptions();
    
    public AxisOptions getXaxis() {
        return xaxis;
    }
    public AxisOptions getYaxis() {
        return yaxis;
    }
    public AxisOptions getX2axis() {
        return x2axis;
    }
    public AxisOptions getY2axis() {
        return y2axis;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("xaxis", xaxis)
            .raw("yaxis", yaxis)
            .raw("x2axis", x2axis)
            .raw("y2axis", y2axis)
            .toString();
    }
}
