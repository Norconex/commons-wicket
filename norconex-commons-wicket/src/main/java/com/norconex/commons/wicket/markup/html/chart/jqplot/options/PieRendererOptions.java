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


/**
 * JQPlot pie renderer options.
 * http://www.jqplot.com/docs/files/plugins/jqplot-pieRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class PieRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = 411043890660222987L;

    public static final String DATALABEL_LABEL   = "label";
    public static final String DATALABEL_VALUE   = "value";
    public static final String DATALABEL_PERCENT = "percent";
    
    private final AnimationOptions animation = new AnimationOptions();
    private Integer diameter;
    private Integer padding;
    private Integer sliceMargin;
    private Boolean fill;
    private String[] dataLabels;
    private String dataLabelFormatString;
    private Float dataLabelPositionFactor;
    private Boolean dataLabelCenterOn;
    private Boolean showDataLabels;
    private Boolean highlightMouseOver;
    private Boolean highlightMouseDown;
    private String[] highlightColors;
    
    /*

$.jqplot.PieRenderer    Plugin renderer to draw a pie chart.

shadowOffset    offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
shadowAlpha     transparency of the shadow (0 = transparent, 1 = opaque)
shadowDepth     number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
dataLabelThreshold      Threshhold in percentage (0-100) of pie area, below which no label will be displayed.
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

    public String[] getDataLabels() {
        return dataLabels;
    }
    /**
     * Sets either ‘label’, ‘value’, ‘percent’ or an array of labels to place
     * on the pie slices.  Defaults to percentage of each pie slice.
     * @param dataLabels data labels
     */
    public void setDataLabels(String... dataLabels) {
        this.dataLabels = dataLabels;
    }

    public Float getDataLabelPositionFactor() {
        return dataLabelPositionFactor;
    }
    public String getDataLabelFormatString() {
        return dataLabelFormatString;
    }
    /**
     * Sets the format string for data labels. For example, if "dataLabels"
     * is set to "value" and "percent", you could use this format: 
     * "%d %d%%".
     * @param dataLabelFormatString format string for data labels
     */
    public void setDataLabelFormatString(String dataLabelFormatString) {
        this.dataLabelFormatString = dataLabelFormatString;
    }
    /**
     * Sets a Multiplier (0-1) of the pie radius which controls position of 
     * label on slice.  Increasing will slide label toward edge of pie, 
     * decreasing will slide label toward center of pie.
     * @param dataLabelPositionFactor slice label position multiplier
     */
    public void setDataLabelPositionFactor(Float dataLabelPositionFactor) {
        this.dataLabelPositionFactor = dataLabelPositionFactor;
    }

    public Boolean getDataLabelCenterOn() {
        return dataLabelCenterOn;
    }
    /**
     * Whether to center the data label at its position. False to set the inside
     * facing edge of the label at its position.
     * @param dataLabelCenterOn true to center the data label at its position
     */
    public void setDataLabelCenterOn(Boolean dataLabelCenterOn) {
        this.dataLabelCenterOn = dataLabelCenterOn;
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
    
    public Boolean getHighlightMouseDown() {
        return highlightMouseDown;
    }
    /**
     * Whether to highlight when a mouse button is pressed over a slice.  
     * This will be disabled if highlightMouseOver is true.
     * @param highlightMouseDown true to highlight when mouse button is pressed 
     */
    public void setHighlightMouseDown(Boolean highlightMouseDown) {
        this.highlightMouseDown = highlightMouseDown;
    }

    public String[] getHighlightColors() {
        return highlightColors;
    }
    /**
     * Sets an array of colors to use when highlighting a slice.
     * @param highlightColors an array of colors (HTML style)
     */
    public void setHighlightColors(String... highlightColors) {
        this.highlightColors = highlightColors;
    }
    
    

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .number("diameter", diameter)
            .number("padding", padding)
            .number("sliceMargin", sliceMargin)
            .bool("fill", fill)
            .bool("showDataLabels", showDataLabels)
            .stringArray("dataLabels", dataLabels)
            .string("dataLabelFormatString", dataLabelFormatString)
            .decimal("dataLabelPositionFactor", dataLabelPositionFactor)
            .bool("dataLabelCenterOn ", dataLabelCenterOn )
            .bool("highlightMouseOver", highlightMouseOver)
            .bool("highlightMouseDown", highlightMouseDown)
            .stringArray("highlightColors", highlightColors)
            .toString();
    }
}
