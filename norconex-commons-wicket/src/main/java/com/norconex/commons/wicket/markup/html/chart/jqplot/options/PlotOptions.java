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
import java.util.ArrayList;
import java.util.List;

/**
 * JQPlot plot options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class PlotOptions implements Serializable {

    private static final long serialVersionUID = -4032037639543272773L;

    private Boolean animate;
    private Boolean captureRightClick;
    private String[] seriesColors;
    private Boolean stackSeries;
    private String title;
    private final AxisOptions axesDefault = new AxisOptions();
    private final Axes axes = new Axes();
    private final SeriesOptions seriesDefaults = new SeriesOptions();
    private final List<SeriesOptions> series = new ArrayList<SeriesOptions>();
    private final LegendOptions legend = new LegendOptions();
    private final GridOptions grid = new GridOptions();
    private final HighlighterOptions highlighter = new HighlighterOptions();
    private final CursorOptions cursor = new CursorOptions();
    
    public String[] getSeriesColors() {
        return seriesColors;
    }
    /**
     * Sets colors that will be assigned to the series.  
     * If there are more series than colors, colors 
     * will wrap around and start at the beginning again.
     * @param seriesColors series colors
     */
    public void setSeriesColors(String... seriesColors) {
        this.seriesColors = seriesColors;
    }
    public Boolean getStackSeries() {
        return stackSeries;
    }
    /**
     * Sets whether to create a stack plot.
     * Currently supported by line and bar graphs.
     * @param stackSeries true to create stack plot
     */
    public void setStackSeries(Boolean stackSeries) {
        this.stackSeries = stackSeries;
    }
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title for the plot.
     * @param title title for the plot
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Gets default options for all axes.
     * @return default axis options
     */
    public AxisOptions getAxesDefault() {
        return axesDefault;
    }
    /**
     * Gets axes.
     * @return axes
     */
    public Axes getAxes() {
        return axes;
    }
    /**
     * Gets the series default options.
     * @return series default options
     */
    public SeriesOptions getSeriesDefaults() {
        return seriesDefaults;
    }
    /**
     * Gets the plot series.
     * @return plot series
     */
    public List<SeriesOptions> getSeries() {
        return series;
    }
    public void addSeries(SeriesOptions series) {
        this.series.add(series);
    }
    /**
     * Gets legend options.
     * @return legend options
     */
    public LegendOptions getLegend() {
        return legend;
    }
    /**
     * Gets the grid options.
     * @return grid options
     */
    public GridOptions getGrid() {
        return grid;
    }
    public Boolean getAnimate() {
        return animate;
    }
    /**
     * Sets whether the rendering of each series should be animated.
     * @param animate true to animate series
     */
    public void setAnimate(Boolean animate) {
        this.animate = animate;
    }
    public Boolean getCaptureRightClick() {
        return captureRightClick;
    }
    /**
     * Sets whether to capture mouse right-click events.
     * @param captureRightClick true to capture mouse right-click events
     */
    public void setCaptureRightClick(Boolean captureRightClick) {
        this.captureRightClick = captureRightClick;
    }
    /**
     * Gets highlighter options.
     * @return highlighter options
     */
    public HighlighterOptions getHighlighter() {
        return highlighter;
    }
    /**
     * Gets cursor options.
     * @return cursor options
     */
    public CursorOptions getCursor() {
        return cursor;
    }
    
    @Override
    public String toString() {
        PlotToStringBuilder builder = new PlotToStringBuilder();
        if (animate != null && animate) {
            builder.raw("animate", "!$.jqplot.use_excanvas");
        } else {
            builder.bool("animate", animate);
        }
        return builder
            .bool("captureRightClick", captureRightClick)
            .stringArray("seriesColors", seriesColors)
            .bool("stackSeries", stackSeries)
            .string("title", title)
            .raw("axesDefault", axesDefault)
            .raw("axes", axes)
            .raw("seriesDefaults", seriesDefaults)
            .rawList("series", series)
            .raw("legend", legend)
            .raw("grid", grid)
            .raw("highlighter", highlighter)
            .raw("cursor", cursor)
            .toString();
    }
}
