package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class HighlighterOptions implements Serializable {

    private static final long serialVersionUID = -2883509774877294529L;

    public enum TooltipAxes{x, y, both};

    private Boolean show;
    private Float lineWidthAdjust;
    private Float sizeAdjust;
    private Boolean showTooltip;
    private Location tooltipLocation;
    private Boolean fadeTooltip;
    private String tooltipFadeSpeed;
    private Integer tooltipOffset;
    private TooltipAxes tooltipAxes;
    private String tooltipSeparator;
    private Boolean useAxesFormatters;
    private String tooltipFormatString;
    private Integer yvalues;
    private String formatString;
    private String tooltipContentEditor;
    
    public Float getLineWidthAdjust() {
        return lineWidthAdjust;
    }
    /**
     * Sets the pixels to add to the size line stroking the data point marker
     * when showing highlight.  Only affects non filled data point markers.
     * @param lineWidthAdjust pixels to add 
     */
    public void setLineWidthAdjust(Float lineWidthAdjust) {
        this.lineWidthAdjust = lineWidthAdjust;
    }
    public Float getSizeAdjust() {
        return sizeAdjust;
    }
    /**
     * Sets the pixels to add to the size of filled markers when drawing 
     * highlight.
     * @param sizeAdjust pixels to add 
     */
    public void setSizeAdjust(Float sizeAdjust) {
        this.sizeAdjust = sizeAdjust;
    }
    public Boolean getShowTooltip() {
        return showTooltip;
    }
    /**
     * Sets whether to show a tooltip with data point values.
     * @param showTooltip true to show a tooltip
     */
    public void setShowTooltip(Boolean showTooltip) {
        this.showTooltip = showTooltip;
    }
    public Location getTooltipLocation() {
        return tooltipLocation;
    }
    /**
     * Sets the location of tooltip: n, ne, e, se, s, sw, w, nw.
     * @param tooltipLocation location of tooltip
     */
    public void setTooltipLocation(Location tooltipLocation) {
        this.tooltipLocation = tooltipLocation;
    }
    public Boolean getFadeTooltip() {
        return fadeTooltip;
    }
    /**
     * Sets whether to use fade effect to show/hide tooltip.
     * @param fadeTooltip true to show fade effect
     */
    public void setFadeTooltip(Boolean fadeTooltip) {
        this.fadeTooltip = fadeTooltip;
    }
    public String getTooltipFadeSpeed() {
        return tooltipFadeSpeed;
    }
    /**
     * Sets the tooltip fade speed (slow, def, fast, or a number of 
     * milliseconds).
     * @param tooltipFadeSpeed fade speed
     */
    public void setTooltipFadeSpeed(String tooltipFadeSpeed) {
        this.tooltipFadeSpeed = tooltipFadeSpeed;
    }
    public Integer getTooltipOffset() {
        return tooltipOffset;
    }
    /**
     * Sets the pixel offset of tooltip from the highlight.
     * @param tooltipOffset pixel offset of tooltip from the highlight
     */
    public void setTooltipOffset(Integer tooltipOffset) {
        this.tooltipOffset = tooltipOffset;
    }
    public TooltipAxes getTooltipAxes() {
        return tooltipAxes;
    }
    /**
     * Sets which axis values to display in the tooltip, x, y or both.
     * @param tooltipAxes which axis values to display in the tooltip
     */
    public void setTooltipAxes(TooltipAxes tooltipAxes) {
        this.tooltipAxes = tooltipAxes;
    }
    public String getTooltipSeparator() {
        return tooltipSeparator;
    }
    /**
     * Sets the separator between values in the tooltip.
     * @param tooltipSeparator separator between values in the tooltip
     */
    public void setTooltipSeparator(String tooltipSeparator) {
        this.tooltipSeparator = tooltipSeparator;
    }
    public Boolean getUseAxesFormatters() {
        return useAxesFormatters;
    }
    /**
     * Sets whether to use the same format string and formatters as used in 
     * the axes to display values in the tooltip.
     * @param useAxesFormatters true to use same format string and formatters
     */
    public void setUseAxesFormatters(Boolean useAxesFormatters) {
        this.useAxesFormatters = useAxesFormatters;
    }
    public String getTooltipFormatString() {
        return tooltipFormatString;
    }
    /**
     * Sets the sprintf format string for the tooltip.  only used if
     * useAxesFormatters is false.  Will use sprintf formatter with
     * this string, not the axes formatters.
     * @param tooltipFormatString sprintf format string
     */
    public void setTooltipFormatString(String tooltipFormatString) {
        this.tooltipFormatString = tooltipFormatString;
    }
    public Integer getYvalues() {
        return yvalues;
    }
    /**
     * Number of y values to expect in the data point array.  Typically this 
     * is 1.  Certain plots, like OHLC, will have more y values in each data 
     * point array.
     * @param yvalues number of y values 
     */
    public void setYvalues(Integer yvalues) {
        this.yvalues = yvalues;
    }
    public String getFormatString() {
        return formatString;
    }
    /**
     * Sets the alternative to tooltipFormatString will format the whole 
     * tooltip text, populating with x, y values as indicated by tooltipAxes 
     * option.  So, you could have a tooltip like: 
     * ‘Date: %s, number of cats: %d’ to format the whole tooltip at one go.  
     * If useAxesFormatters is true, values will be formatted according to Axes 
     * formatters and you can populate your tooltip string with %s placeholders.
     * @param formatString alternative to tooltipFormatString
     */
    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }
    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether to show the highlight.
     * @param show true to show the highlight
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public String getTooltipContentEditor() {
        return tooltipContentEditor;
    }
    /**
     * Sets custom callback method to retrieve the tooltip content 
     * (for advanced use).
     * @param tooltipContentEditor raw text
     */
    public void setTooltipContentEditor(String tooltipContentEditor) {
        this.tooltipContentEditor = tooltipContentEditor;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .decimal("lineWidthAdjust", lineWidthAdjust)
            .decimal("sizeAdjust", sizeAdjust)
            .bool("showTooltip", showTooltip)
            .enumString("tooltipLocation", tooltipLocation)
            .string("tooltipFadeSpeed", tooltipFadeSpeed)
            .number("tooltipOffset", tooltipOffset)
            .enumString("tooltipAxes", tooltipAxes)
            .string("tooltipSeparator", tooltipSeparator)
            .bool("useAxesFormatters", useAxesFormatters)
            .string("tooltipFormatString", tooltipFormatString)
            .number("yvalues", yvalues)
            .string("formatString", formatString)
            .raw("tooltipContentEditor", tooltipContentEditor)
            .toString();
    }
}
