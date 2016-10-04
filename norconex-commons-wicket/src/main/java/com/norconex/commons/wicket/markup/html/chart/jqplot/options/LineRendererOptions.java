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


/**
 * JQPlot line renderer options.
 * http://www.jqplot.com/docs/files/jqplot-lineRenderer-js.html
 * @author Pascal Essiembre
 */
public class LineRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -279474992413622308L;

    private final AnimationOptions animation = new AnimationOptions();
    private Boolean smooth;
    private Boolean constrainSmoothing;

    private Boolean highlightMouseOver;
    private Boolean highlightMouseDown;
    private String highlightColor;
    
    /*

bandData    Data used to draw error bands or confidence intervals above/below a line.

show    true to show the bands.
color   color of lines at top and bottom of bands [default: series color].
showLines   True to show lines at top and bottom of bands [default: false].
fill    True to fill area between bands [default: true].
fillColor   css color spec for filled area.
interval    User specified interval above and below line for bands [default: ‘3%’’].

    */

    public AnimationOptions getAnimation() {
        return animation;
    }

    /**
     * Sets whether to draw a smoothed (interpolated) line through the data 
     * points with automatically computed number of smoothing points.
     * @param smooth <code>true</code> to draw a smoothed (interpolated) line
     */
    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }
    public Boolean getSmooth() {
        return smooth;
    }

    /**
     * Sets whether to use a more accurate smoothing algorithm that 
     * will not overshoot any data points.
     * @param constrainSmoothing <code>true</code> to use a more accurate 
     *         smoothing algorithm
     */
    public void setConstrainSmoothing(Boolean constrainSmoothing) {
        this.constrainSmoothing = constrainSmoothing;
    }
    public Boolean getConstrainSmoothing() {
        return constrainSmoothing;
    }

    /**
     * Sets whether to highlight area on a filled plot when moused over.
     * @param highlightMouseOver <code>true</code> to highlight area on a 
     *         filled plot when moused over
     */
    public void setHighlightMouseOver(Boolean highlightMouseOver) {
        this.highlightMouseOver = highlightMouseOver;
    }
    public Boolean getHighlightMouseOver() {
        return highlightMouseOver;
    }

    /**
     * Sets whether to highlight when a mouse button is pressed over an area 
     * on a filled plot.
     * @param highlightMouseDown <code>true</code> to highlight when a mouse 
     *         button is pressed over an area on a filled plot
     */
    public void setHighlightMouseDown(Boolean highlightMouseDown) {
        this.highlightMouseDown = highlightMouseDown;
    }
    public Boolean getHighlightMouseDown() {
        return highlightMouseDown;
    }

    /**
     * Sets the color to use when highlighting an area on a filled plot. 
     * @param highlightColor the color to use when highlighting an area 
     *         on a filled plot
     */
    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }
    public String getHighlightColor() {
        return highlightColor;
    }


    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .bool("smooth", smooth)
            .bool("constrainSmoothing", constrainSmoothing)
            .bool("highlightMouseDown", highlightMouseDown)
            .bool("highlightMouseOver", highlightMouseOver)
            .string("highlightColor", highlightColor)
            .toString();
    }
}
