package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class TickOptions implements Serializable {

    private static final long serialVersionUID = -7884794254501503111L;

    public enum Mark { outside, inside, cross };
    
    private Mark mark;
    private Boolean showMark;
    private Boolean showGridline;
    private Integer markSize;
    private Boolean show;
    private Boolean showLabel;
    private String formatString;

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
            .integer("markSize", markSize)
            .bool("show", show)
            .bool("showLabel", showLabel)
            .string("formatString", formatString)
            .toString();
    }
}
