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
 * JQPlot grid options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class GridOptions implements Serializable {

    private static final long serialVersionUID = -2933379046092416422L;

    public static final String DEFAULT_CANVAS_GRID_RENDERER = 
            "$.jqplot.CanvasGridRenderer";
    
    private Boolean drawGridLines;
    private String gridLineColor;
    private String background;
    private String borderColor;
    private Float borderWidth;
    private Boolean shadow;
    private Integer shadowAngle;
    private Float shadowOffset;
    private Integer shadowWidth;
    private Integer shadowDepth;
    private Float shadowAlpha;
    private String renderer;
    private IGridRendererOptions rendererOptions;

    public Boolean getDrawGridLines() {
        return drawGridLines;
    }
    /**
     * Sets whether to draw lines across the grid or not.
     * @param drawGridLines true to draw lines
     */
    public void setDrawGridLines(Boolean drawGridLines) {
        this.drawGridLines = drawGridLines;
    }
    public String getGridLineColor() {
        return gridLineColor;
    }
    /**
     * Sets the color of the grid lines.
     * @param gridLineColor color of the grid lines
     */
    public void setGridLineColor(String gridLineColor) {
        this.gridLineColor = gridLineColor;
    }
    public String getBackground() {
        return background;
    }
    /**
     * Sets the CSS color spec for background color of grid.
     * @param background CSS color spec for background color of grid
     */
    public void setBackground(String background) {
        this.background = background;
    }
    public String getBorderColor() {
        return borderColor;
    }
    /**
     * Sets the CSS color spec for border around grid.
     * @param borderColor CSS color spec for border around grid
     */
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
    public Float getBorderWidth() {
        return borderWidth;
    }
    /**
     * Sets the pixel width of border around grid.
     * @param borderWidth pixel width of border around grid
     */
    public void setBorderWidth(Float borderWidth) {
        this.borderWidth = borderWidth;
    }
    public Boolean getShadow() {
        return shadow;
    }
    /**
     * Sets whether to draw a shadow for grid.
     * @param shadow true to draw a shadow
     */
    public void setShadow(Boolean shadow) {
        this.shadow = shadow;
    }
    public Integer getShadowAngle() {
        return shadowAngle;
    }
    /**
     * Sets the angle of the shadow.  Clockwise from x axis.
     * @param shadowAngle angle of the shadow
     */
    public void setShadowAngle(Integer shadowAngle) {
        this.shadowAngle = shadowAngle;
    }
    public Float getShadowOffset() {
        return shadowOffset;
    }
    /**
     * Sets the offset from the line of the shadow
     * @param shadowOffset offset from the line of the shadow
     */
    public void setShadowOffset(Float shadowOffset) {
        this.shadowOffset = shadowOffset;
    }
    public Integer getShadowWidth() {
        return shadowWidth;
    }
    /**
     * Sets the width of the stroke for the shadow.
     * @param shadowWidth width of the stroke for the shadow
     */
    public void setShadowWidth(Integer shadowWidth) {
        this.shadowWidth = shadowWidth;
    }
    public Integer getShadowDepth() {
        return shadowDepth;
    }
    /**
     * Sets the number of strokes to make when drawing shadow.
     * Each stroke offset by shadowOffset from the last.
     * @param shadowDepth shadow depth
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
    public String getRenderer() {
        return renderer;
    }
    /**
     * Sets the renderer to use to draw the grid.
     * @param renderer renderer to use to draw the grid
     */
    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }
    public IGridRendererOptions getRendererOptions() {
        return rendererOptions;
    }
    /**
     * Sets options to pass to the renderer.  Note, the default
     * CanvasGridRenderer takes no additional options.
     * @param rendererOptions renderer options
     */
    public void setRendererOptions(IGridRendererOptions rendererOptions) {
        this.rendererOptions = rendererOptions;
    }

    
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("drawGridLines", drawGridLines)
            .string("gridLineColor", gridLineColor)
            .string("background", background)
            .string("borderColor", borderColor)
            .decimal("borderWidth", borderWidth)
            .bool("shadow", shadow)
            .number("shadowAngle", shadowAngle)
            .decimal("shadowOffset", shadowOffset)
            .number("shadowWidth", shadowWidth)
            .number("shadowDepth", shadowDepth)
            .decimal("shadowAlpha", shadowAlpha)
            .raw("renderer", renderer)
            .raw("rendererOptions", rendererOptions)
            .toString();
    }
}
