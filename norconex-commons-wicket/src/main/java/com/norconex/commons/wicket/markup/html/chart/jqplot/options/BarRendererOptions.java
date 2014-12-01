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
 * JQPlot bar-renderer options.
 * http://www.jqplot.com/docs/files/jqplot-lineRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class BarRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -4216812235319965699L;

    public enum Direction {vertical, horizontal}
    
    private final AnimationOptions animation = new AnimationOptions();
    private Integer barPadding;
    private Integer barMargin;
    private Direction barDirection;
    private Integer barWidth;
    
    /*

barPadding      Number of pixels between adjacent bars at the same axis value.
barMargin       Number of pixels between groups of bars at adjacent axis values.
barDirection    ‘vertical’ = up and down bars, ‘horizontal’ = side to side bars
barWidth        Width of the bar in pixels (auto by devaul).
shadowOffset    offset of the shadow from the slice and offset of each succesive stroke of the shadow from the last.
shadowDepth     number of strokes to apply to the shadow, each stroke offset shadowOffset from the last.
shadowAlpha     transparency of the shadow (0 = transparent, 1 = opaque)
waterfall       true to enable waterfall plot.
groups  group bars into this many groups
varyBarColor    true to color each bar of a series separately rather than have every bar of a given series the same color.
highlightMouseOver      True to highlight slice when moused over.
highlightMouseDown      True to highlight when a mouse button is pressed over a slice.
highlightColors an array of colors to use when highlighting a bar.

     */

    public AnimationOptions getAnimation() {
        return animation;
    }
    public Integer getBarPadding() {
        return barPadding;
    }
    public void setBarPadding(Integer barPadding) {
        this.barPadding = barPadding;
    }
    public Integer getBarMargin() {
        return barMargin;
    }
    public void setBarMargin(Integer barMargin) {
        this.barMargin = barMargin;
    }
    public Direction getBarDirection() {
        return barDirection;
    }
    public void setBarDirection(Direction barDirection) {
        this.barDirection = barDirection;
    }
    public Integer getBarWidth() {
        return barWidth;
    }
    public void setBarWidth(Integer barWidth) {
        this.barWidth = barWidth;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .number("barPadding", barPadding)
            .number("barMargin", barMargin)
            .enumString("barDirection", barDirection)
            .number("barWidth", barWidth)
            .toString();
    }
}
