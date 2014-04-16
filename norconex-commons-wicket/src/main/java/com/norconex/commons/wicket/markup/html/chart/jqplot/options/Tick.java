package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("nls")
public class Tick implements Serializable {

    private static final long serialVersionUID = -789197979622733338L;

    private String value;
    private String label;

    public Tick() {
        super();
    }
    public Tick(String value) {
        super();
        this.value = value;
    }
    public Tick(String value, String label) {
        super();
        this.value = value;
        this.label = label;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        if (value == null) {
            return StringUtils.EMPTY;
        } 
        if (label == null) {
            return "'" + PlotToStringBuilder.esc(value) + "'";
        }
        return "['" + PlotToStringBuilder.esc(value) + "', '" 
                + PlotToStringBuilder.esc(label) + "']";
    }
}
