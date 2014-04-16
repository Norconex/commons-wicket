package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class SeriesOptions implements Serializable {

    private static final long serialVersionUID = 5697253096592169783L;

    /**
     * Default.
     */
    public static final String LINE_RENDERER = "$.jqplot.LineRenderer";
    /**
     * Default.
     */
    public static final String MARKER_RENDERER = 
            "$.jqplot.MarkerRenderer";
    
    public static final String BAR_RENDERER = "$.jqplot.BarRenderer";
    public static final String PIE_RENDERER = "$.jqplot.PieRenderer";
    
    public enum XAxis { xaxis, x2axis };
    public enum YAxis { yaxis, y2axis };
    
    private Boolean show;
    private XAxis xaxis;
    private YAxis yaxis;
    private String label;
    private String color;
    private Float lineWidth;
    private Boolean shadow;
    private Integer shadowAngle;
    private Float shadowOffset;
    private Integer shadowDepth;
    private Float shadowAlpha;
    private Boolean showLine;
    private Boolean showMarker;
    private Boolean fill;
    private Boolean fillAndStroke;
    private String fillColor;
    private Float fillAlpha;
    private String renderer;
    private ISeriesRendererOptions rendererOptions;
    private String markerRenderer;
    private final MarkerOptions markerOptions = new MarkerOptions();
    private final PointLabelOptions pointLabels = new PointLabelOptions();

    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether to render the series.
     * @param show true to render the series
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public XAxis getXaxis() {
        return xaxis;
    }
    /**
     * Sets which x axis to use (either 'xaxis' or 'x2axis').
     * @param xaxis which x axis to use
     */
    public void setXaxis(XAxis xaxis) {
        this.xaxis = xaxis;
    }
    public YAxis getYaxis() {
        return yaxis;
    }
    /**
     * Sets which y axis to use (either 'yaxis' or 'y2axis').
     * @param yaxis which y axis to use
     */
    public void setYaxis(YAxis yaxis) {
        this.yaxis = yaxis;
    }
    public String getLabel() {
        return label;
    }
    /**
     * Sets the label to use in the legend for this line.
     * @param label label to use in the legend for this line
     */
    public void setLabel(String label) {
        this.label = label;
    }
    public String getColor() {
        return color;
    }
    /**
     * Sets the CSS color spec to use for the line.  Determined automatically.
     * @param color CSS color spec to use for the line
     */
    public void setColor(String color) {
        this.color = color;
    }
    public Float getLineWidth() {
        return lineWidth;
    }
    /**
     * Sets the width of the line in pixels.
     * @param lineWidth width of the line in pixels.
     */
    public void setLineWidth(Float lineWidth) {
        this.lineWidth = lineWidth;
    }
    public Boolean getShadow() {
        return shadow;
    }
    /**
     * Sets whether to show shadow or not.
     * @param shadow true to show shadow
     */
    public void setShadow(Boolean shadow) {
        this.shadow = shadow;
    }
    public Integer getShadowAngle() {
        return shadowAngle;
    }
    /**
     * Sets the angle (degrees) of the shadow, clockwise from x axis.
     * @param shadowAngle angle (degrees) of the shadow.
     */
    public void setShadowAngle(Integer shadowAngle) {
        this.shadowAngle = shadowAngle;
    }
    public Float getShadowOffset() {
        return shadowOffset;
    }
    /**
     * Sets the offset from the line of the shadow.
     * @param shadowOffset offset from the line of the shadow
     */
    public void setShadowOffset(Float shadowOffset) {
        this.shadowOffset = shadowOffset;
    }
    public Integer getShadowDepth() {
        return shadowDepth;
    }
    /**
     * Sets the number of strokes to make when drawing shadow.  Each
     * stroke offset by shadowOffset from the last.
     * @param shadowDepth number of strokes to make when drawing shadow
     */
    public void setShadowDepth(Integer shadowDepth) {
        this.shadowDepth = shadowDepth;
    }
    public Float getShadowAlpha() {
        return shadowAlpha;
    }
    /**
     * Sets the opacity of the shadow.
     * @param shadowAlpha opacity of the shadow
     */
    public void setShadowAlpha(Float shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
    }
    public Boolean getShowLine() {
        return showLine;
    }
    /**
     * Sets whether to render the line segments or not. 
     * @param showLine true to render the line
     */
    public void setShowLine(Boolean showLine) {
        this.showLine = showLine;
    }
    public Boolean getShowMarker() {
        return showMarker;
    }
    /**
     * Sets whether to render the data point markers or not.
     * @param showMarker true to render the data point markers 
     */
    public void setShowMarker(Boolean showMarker) {
        this.showMarker = showMarker;
    }
    public Boolean getFill() {
        return fill;
    }
    /**
     * Sets whether to fill under the line
     * @param fill true to fill under the line
     */
    public void setFill(Boolean fill) {
        this.fill = fill;
    }
    public Boolean getFillAndStroke() {
        return fillAndStroke;
    }
    /**
     * Sets whether to stroke a line at top of fill area.
     * @param fillAndStroke true to stroke a line at top of fill area
     */
    public void setFillAndStroke(Boolean fillAndStroke) {
        this.fillAndStroke = fillAndStroke;
    }
    public String getFillColor() {
        return fillColor;
    }
    /**
     * Sets the custom fill color for filled lines (default is line color).
     * @param fillColor custom fill color for filled lines
     */
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
    public Float getFillAlpha() {
        return fillAlpha;
    }
    /**
     * Sets a custom alpha to apply to fillColor.
     * @param fillAlpha custom alpha to apply to fillColor
     */
    public void setFillAlpha(Float fillAlpha) {
        this.fillAlpha = fillAlpha;
    }
    public String getRenderer() {
        return renderer;
    }
    /**
     * Sets the renderer used to draw the series.
     * @param renderer the renderer used to draw the series
     */
    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }
    public ISeriesRendererOptions getRendererOptions() {
        return rendererOptions;
    }
    /**
     * Sets the options passed to the renderer (LineRenderer has no options).
     * @param renderOptions
     */
    public void setRendererOptions(ISeriesRendererOptions renderOptions) {
        this.rendererOptions = renderOptions;
    }
    public String getMarkerRenderer() {
        return markerRenderer;
    }
    /**
     * Sets the renderer to use to draw the data point markers.
     * @param markerRenderer renderer to use to draw the data point markers
     */
    public void setMarkerRenderer(String markerRenderer) {
        this.markerRenderer = markerRenderer;
    }
    /**
     * Gets marker options.
     * @return marker options
     */
    public MarkerOptions getMarkerOptions() {
        return markerOptions;
    }
    /**
     * Gets point label options.
     * @return point label options
     */
    public PointLabelOptions getPointLabels() {
        return pointLabels;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .enumString("xaxis", xaxis)
            .enumString("yaxis", yaxis)
            .string("label", label)
            .string("color", color)
            .decimal("lineWidth", lineWidth)
            .bool("shadow", shadow)
            .integer("shadowAngle", shadowAngle)
            .decimal("shadowOffset", shadowOffset)
            .integer("shadowDepth", shadowDepth)
            .decimal("shadowAlpha", shadowAlpha)
            .bool("showLine", showLine)
            .bool("showMarker", showMarker)
            .bool("fill", fill)
            .bool("fillAndStroke", fillAndStroke)
            .string("fillColor", fillColor)
            .decimal("fillAlpha", fillAlpha)
            .raw("renderer", renderer)
            .raw("rendererOptions", rendererOptions)
            .string("markerRenderer", markerRenderer)
            .raw("markerRenderer", markerRenderer)
            .raw("pointLabels", pointLabels)
            .toString();
    }
}

