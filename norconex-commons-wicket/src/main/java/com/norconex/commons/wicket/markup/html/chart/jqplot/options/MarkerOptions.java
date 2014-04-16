package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class MarkerOptions implements Serializable {

    private static final long serialVersionUID = -1766272455353520759L;

    private Boolean show;
    private String style;
    private Integer lineWidth;
    private Integer size;
    private String color;
    private Boolean shadow;
    private Integer shadowAngle;
    private Integer shadowOffset;
    private Integer shadowDepth;
    private Float shadowAlpha;
    
    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public Integer getLineWidth() {
        return lineWidth;
    }
    public void setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
    }
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean getShadow() {
        return shadow;
    }
    public void setShadow(Boolean shadow) {
        this.shadow = shadow;
    }
    public Integer getShadowAngle() {
        return shadowAngle;
    }
    public void setShadowAngle(Integer shadowAngle) {
        this.shadowAngle = shadowAngle;
    }
    public Integer getShadowOffset() {
        return shadowOffset;
    }
    public void setShadowOffset(Integer shadowOffset) {
        this.shadowOffset = shadowOffset;
    }
    public Integer getShadowDepth() {
        return shadowDepth;
    }
    public void setShadowDepth(Integer shadowDepth) {
        this.shadowDepth = shadowDepth;
    }
    public Float getShadowAlpha() {
        return shadowAlpha;
    }
    public void setShadowAlpha(Float shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .string("style", style)
            .integer("lineWidth", lineWidth)
            .integer("size", size)
            .string("color", color)
            .bool("shadow", shadow)
            .integer("shadowAngle", shadowAngle)
            .integer("shadowOffset", shadowOffset)
            .integer("shadowDepth", shadowDepth)
            .decimal("shadowAlpha", shadowAlpha)
            .toString();
    }
}
