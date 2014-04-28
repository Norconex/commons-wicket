package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
     * @param series plot series
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


/*

options =
{


    // Plugin and renderer options.

    // BarRenderer.
    // With BarRenderer, you can specify additional options in the rendererOptions object
    // on the series or on the seriesDefaults object.  Note, some options are respecified
    // (like shadowDepth) to override lineRenderer defaults from which BarRenderer inherits.

    seriesDefaults: {
        rendererOptions: {
            barPadding: 8,      // number of pixels between adjacent bars in the same
                                // group (same category or bin).
            barMargin: 10,      // number of pixels between adjacent groups of bars.
            barDirection: 'vertical', // vertical or horizontal.
            barWidth: null,     // width of the bars.  null to calculate automatically.
            shadowOffset: 2,    // offset from the bar edge to stroke the shadow.
            shadowDepth: 5,     // nuber of strokes to make for the shadow.
            shadowAlpha: 0.8,   // transparency of the shadow.
        }
    },

    // Cursor
    // Options are passed to the cursor plugin through the "cursor" object at the top
    // level of the options object.

    cursor: {
        style: 'crosshair',     // A CSS spec for the cursor type to change the
                                // cursor to when over plot.
        show: true,
        showTooltip: true,      // show a tooltip showing cursor position.
        followMouse: false,     // wether tooltip should follow the mouse or be stationary.
        tooltipLocation: 'se',  // location of the tooltip either relative to the mouse
                                // (followMouse=true) or relative to the plot.  One of
                                // the compass directions, n, ne, e, se, etc.
        tooltipOffset: 6,       // pixel offset of the tooltip from the mouse or the axes.
        showTooltipGridPosition: false,     // show the grid pixel coordinates of the mouse
                                            // in the tooltip.
        showTooltipUnitPosition: true,      // show the coordinates in data units of the mouse
                                            // in the tooltip.
        tooltipFormatString: '%.4P',    // sprintf style format string for tooltip values.
        useAxesFormatters: true,        // wether to use the same formatter and formatStrings
                                        // as used by the axes, or to use the formatString
                                        // specified on the cursor with sprintf.
        tooltipAxesGroups: [],  // show only specified axes groups in tooltip.  Would specify like:
                                // [['xaxis', 'yaxis'], ['xaxis', 'y2axis']].  By default, all axes
                                // combinations with for the series in the plot are shown.

    },

    // Dragable
    // Dragable options are specified with the "dragable" object at the top level
    // of the options object.

    dragable: {
        color: undefined,       // custom color to use for the dragged point and dragged line
                                // section. default will use a transparent variant of the line color.
        constrainTo: 'none',    // Constrain dragging motion to an axis: 'x', 'y', or 'none'.
    },

    // Highlighter
    // Highlighter options are specified with the "highlighter" object at the top level
    // of the options object.

    highlighter: {
        lineWidthAdjust: 2.5,   // pixels to add to the size line stroking the data point marker
                                // when showing highlight.  Only affects non filled data point markers.
        sizeAdjust: 5,          // pixels to add to the size of filled markers when drawing highlight.
        showTooltip: true,      // show a tooltip with data point values.
        tooltipLocation: 'nw',  // location of tooltip: n, ne, e, se, s, sw, w, nw.
        fadeTooltip: true,      // use fade effect to show/hide tooltip.
        tooltipFadeSpeed: "fast"// slow, def, fast, or a number of milliseconds.
        tooltipOffset: 2,       // pixel offset of tooltip from the highlight.
        tooltipAxes: 'both',    // which axis values to display in the tooltip, x, y or both.
        tooltipSeparator: ', '  // separator between values in the tooltip.
        useAxesFormatters: true // use the same format string and formatters as used in the axes to
                                // display values in the tooltip.
        tooltipFormatString: '%.5P' // sprintf format string for the tooltip.  only used if
                                    // useAxesFormatters is false.  Will use sprintf formatter with
                                    // this string, not the axes formatters.
    },

    // LogAxisRenderer
    // LogAxisRenderer add 2 options to the axes object.  These options are specified directly on
    // the axes or axesDefaults object.

    axesDefaults: {
        base: 10,                   // the logarithmic base.
        tickDistribution: 'even',   // 'even' or 'power'.  'even' will produce with even visiual (pixel)
                                    // spacing on the axis.  'power' will produce ticks spaced by
                                    // increasing powers of the log base.
    },

    // PieRenderer
    // PieRenderer accepts options from the rendererOptions object of the series or seriesDefaults object.

    seriesDefaults: {
        rendererOptions: {
            diameter: undefined, // diameter of pie, auto computed by default.
            padding: 20,        // padding between pie and neighboring legend or plot margin.
            sliceMargin: 0,     // gap between slices.
            fill: true,         // render solid (filled) slices.
            shadowOffset: 2,    // offset of the shadow from the chart.
            shadowDepth: 5,     // Number of strokes to make when drawing shadow.  Each stroke
                                // offset by shadowOffset from the last.
            shadowAlpha: 0.07   // Opacity of the shadow
        }
    },

    // Trendline
    // Trendline takes options on the trendline object of the series or seriesDefaults object.

    seriesDefaults: {
        trendline: {
            show: true,         // show the trend line
            color: '#666666',   // CSS color spec for the trend line.
            label: '',          // label for the trend line.
            type: 'linear',     // 'linear', 'exponential' or 'exp'
            shadow: true,       // show the trend line shadow.
            lineWidth: 1.5,     // width of the trend line.
            shadowAngle: 45,    // angle of the shadow.  Clockwise from x axis.
            shadowOffset: 1.5,  // offset from the line of the shadow.
            shadowDepth: 3,     // Number of strokes to make when drawing shadow.
                                // Each stroke offset by shadowOffset from the last.
            shadowAlpha: 0.07   // Opacity of the shadow
        }
    }
}

*/