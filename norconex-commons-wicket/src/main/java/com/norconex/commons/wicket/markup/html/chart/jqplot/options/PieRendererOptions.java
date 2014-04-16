package com.norconex.commons.wicket.markup.html.chart.jqplot.options;


/**
 * http://www.jqplot.com/docs/files/plugins/jqplot-pieRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class PieRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = 411043890660222987L;

    private final AnimationOptions animation = new AnimationOptions();
    private Integer diameter;
    private Integer padding;
    private Integer sliceMargin;
    private Boolean fill;
    private Boolean showDataLabels;
    private Boolean highlightMouseOver;
    
    /*

$.jqplot.PieRenderer    Plugin renderer to draw a pie chart.

shadowOffset    offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
shadowAlpha     transparency of the shadow (0 = transparent, 1 = opaque)
shadowDepth     number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
highlightMouseDown      True to highlight when a mouse button is pressed over a slice.
highlightColors an array of colors to use when highlighting a slice.
dataLabels      Either ‘label’, ‘value’, ‘percent’ or an array of labels to place on the pie slices.
dataLabelFormatString   Format string for data labels.
dataLabelThreshold      Threshhold in percentage (0-100) of pie area, below which no label will be displayed.
dataLabelPositionFactor A Multiplier (0-1) of the pie radius which controls position of label on slice.
dataLabelNudge  Number of pixels to slide the label away from (+) or toward (-) the center of the pie.
dataLabelCenterOn       True to center the data label at its position.
startAngle      Angle to start drawing pie in degrees.

$.jqplot.PieLegendRenderer      Legend Renderer specific to pie plots.

numberRows      Maximum number of rows in the legend.
numberColumns   Maximum number of columns in the legend. 

     */

    public AnimationOptions getAnimation() {
        return animation;
    }
    
    public Integer getDiameter() {
        return diameter;
    }
    /**
     * Sets the outer diameter of the pie, auto computed by default.
     * @param diameter diameter of the pie
     */
    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }
    public Integer getPadding() {
        return padding;
    }
    /**
     * Sets the padding between the pie and plot edges, legend, etc.
     * @param padding padding between the pie and plot edges, legend, etc
     */
    public void setPadding(Integer padding) {
        this.padding = padding;
    }
    public Integer getSliceMargin() {
        return sliceMargin;
    }
    /**
     * Sets the angular spacing between pie slices in degrees.
     * @param sliceMargin angular spacing between pie slices in degree
     */
    public void setSliceMargin(Integer sliceMargin) {
        this.sliceMargin = sliceMargin;
    }
    public Boolean getFill() {
        return fill;
    }
    /**
     * Sets whether to fill the slices.
     * @param fill true to fill the slices
     */
    public void setFill(Boolean fill) {
        this.fill = fill;
    }
    public Boolean getShowDataLabels() {
        return showDataLabels;
    }
    /**
     * Sets whether to show data labels on slices.
     * @param showDataLabels true to show data labels on slices
     */
    public void setShowDataLabels(Boolean showDataLabels) {
        this.showDataLabels = showDataLabels;
    }
    public Boolean getHighlightMouseOver() {
        return highlightMouseOver;
    }
    /**
     * Sets whether to highlight slice when moused over.
     * @param highlightMouseOver true to highlight slice when moused over.
     */
    public void setHighlightMouseOver(Boolean highlightMouseOver) {
        this.highlightMouseOver = highlightMouseOver;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .integer("diameter", diameter)
            .integer("padding", padding)
            .integer("sliceMargin", sliceMargin)
            .bool("fill", fill)
            .bool("showDataLabels", showDataLabels)
            .bool("highlightMouseOver", highlightMouseOver)
            .toString();
    }
}
