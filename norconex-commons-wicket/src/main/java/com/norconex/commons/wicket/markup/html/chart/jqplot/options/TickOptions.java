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
package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

/**
 * JQPlot tick options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class TickOptions implements Serializable {

    private static final long serialVersionUID = -7884794254501503111L;

    public enum Mark { outside, inside, cross };
    
    private Integer angle;
    private Mark mark;
    private Boolean showMark;
    private Boolean showGridline;
    private Integer markSize;
    private Boolean show;
    private Boolean showLabel;
    private String formatString;
    private Boolean enableFontSupport;
    private String fontFamily;
    private String fontSize;

    
    
    public String getFontFamily() {
        return fontFamily;
    }
    /**
     * Sets css spec for the font-family css attribute.
     * @param fontFamily font family
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }
    public String getFontSize() {
        return fontSize;
    }
    /**
     * Sets CSS spec for font size.
     * @param fontSize font size
     */
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
    
    public Boolean getEnableFontSupport() {
        return enableFontSupport;
    }
    /**
     * Sets whether to turn on native canvas font support in Mozilla 3.5+ and 
     * Safari 4+. 
     * @param enableFontSupport <code>true</code> to turn on
     */
    public void setEnableFontSupport(Boolean enableFontSupport) {
        this.enableFontSupport = enableFontSupport;
    }

    public Integer getAngle() {
        return angle;
    }
    /**
     * Sets angle of text, measured clockwise from x axis.
     * @param angle angle of text
     */
    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Mark getMark() {
        return mark;
    }
    /**
     * Sets where to put the tick mark on the axis
     * (one of 'outside', 'inside' or 'cross').
     * @param mark
     */
    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Boolean getShowMark() {
        return showMark;
    }
    /**
     * Sets whether or not to show the mark on the axis.
     * @param showMark whether or not to show the mark on the axis
     */
    public void setShowMark(Boolean showMark) {
        this.showMark = showMark;
    }
    public Boolean getShowGridline() {
        return showGridline;
    }
    /**
     * Sets whether to draw a grid line (across the whole grid) at this tick.
     * @param showGridline whether to draw a grid line at this tick
     */
    public void setShowGridline(Boolean showGridline) {
        this.showGridline = showGridline;
    }
    public Integer getMarkSize() {
        return markSize;
    }
    /**
     * Sets the length the tick will extend beyond the grid in pixels.  For
     * 'cross', length will be added above and below the grid boundary.
     * @param markSize length of the tick
     */
    public void setMarkSize(Integer markSize) {
        this.markSize = markSize;
    }
    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether to show the tick (mark and label).
     * @param show whether to show the tick
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public Boolean getShowLabel() {
        return showLabel;
    }
    /**
     * Sets whether to show the text label at the tick.
     * @param showLabel whether to show the text label at the tick
     */
    public void setShowLabel(Boolean showLabel) {
        this.showLabel = showLabel;
    }
    public String getFormatString() {
        return formatString;
    }
    /**
     * Sets the format string to use with the axis tick formatter.
     * @param formatString format string to use with the axis tick formatter
     */
    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .enumString("mark", mark)
            .bool("showMark", showMark)
            .bool("showGridline", showGridline)
            .number("angle", angle)
            .number("markSize", markSize)
            .bool("show", show)
            .bool("showLabel", showLabel)
            .bool("enableFontSupport", enableFontSupport)
            .string("formatString", formatString)
            .string("fontSize", fontSize)
            .string("fontFamily", fontFamily)
            .toString();
    }
}
