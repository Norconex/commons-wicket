/* Copyright 2012-2016 Norconex Inc.
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
package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

/**
 * JQPlot marker options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class MarkerOptions implements Serializable {

    private static final long serialVersionUID = -1766272455353520759L;

    public enum Style {
        DIAMOND("diamond"),
        CIRCLE("circle"),
        SQUARE("square"),
        X("x"),
        PLUS("plus"),
        DASH("dash"),
        FILLED_DIAMOND("filledDiamond"), 
        FILLED_CIRCLE("filledCircle"),
        FILLED_SQUARE("filledSquare");
        private String style;
        Style(String style) {
            this.style = style;
        }
        @Override
        public String toString() {
            return style;
        }
    }
    
    private Boolean show;
    private Style style;
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
    public Style getStyle() {
        return style;
    }
    public void setStyle(Style style) {
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
            .enumString("style", style)
            .number("lineWidth", lineWidth)
            .number("size", size)
            .string("color", color)
            .bool("shadow", shadow)
            .number("shadowAngle", shadowAngle)
            .number("shadowOffset", shadowOffset)
            .number("shadowDepth", shadowDepth)
            .decimal("shadowAlpha", shadowAlpha)
            .toString();
    }
}
