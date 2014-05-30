package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class AxisOptions implements Serializable {

    private static final long serialVersionUID = 6301715087048190655L;

    /**
     * Default axis renderer.
     */
    public static final String LINEAR_AXIS_RENDERER = 
            "$.jqplot.LinearAxisRenderer";
    /**
     * A plugin for jqPlot to render a category style axis, with equal pixel 
     * spacing between y data values of a series.
     * http://www.jqplot.com/docs/files/plugins/jqplot-categoryAxisRenderer-js.html
     */
    public static final String CATEGORY_AXIS_RENDERER = 
            "$.jqplot.CategoryAxisRenderer";

    /**
     * A plugin for a jqPlot to render an axis as a series of date values.  
     * This renderer has no options beyond those supplied by the Axis class.  
     * It supplies it’s own tick formatter, so the tickOptions.formatter option 
     * should not be overridden.
     * http://www.jqplot.com/docs/files/plugins/jqplot-dateAxisRenderer-js.html
     */
    public static final String DATE_AXIS_RENDERER = "$.jqplot.DateAxisRenderer";

    /**
     * A "tick" object showing the value of a tick/gridline on the plot.
     */
    public static final String AXIS_TICK_RENDERER = "$.jqplot.AxisTickRenderer";
    
    /**
     * Renderer to draw axis ticks with a canvas element to support advanced 
     * features such as rotated text.
     */
    public static final String CANVAS_AXIS_TICK_RENDERER = 
            "$.jqplot.CanvasAxisTickRenderer";
    
    
    private Boolean show;
    private String min;
    private String max;
    private Float pad;
    private Float padMin;
    private Float padMax;
    private Tick[] ticks;
    private Integer numberTicks;
    private String tickInterval;
    private String renderer;
    private IAxisRendererOptions rendererOptions;
    private String tickRenderer;
    private final TickOptions tickOptions = new TickOptions();
    private Boolean showTicks;
    private Boolean showTickMarks;
    
    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether or not to renderer the axis.  Determined automatically.
     * @param show true to render the axis
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public String getMin() {
        return min;
    }
    /**
     * Sets the minimum value of the axis.  Determined automatically.
     * @param min minimum value of the axis
     */
    public void setMin(String min) {
        this.min = min;
    }
    /**
     * Sets the minimum numerical value of the axis.  Determined automatically.
     * @param min minimum value of the axis
     */
    public void setMin(int min) {
        this.min = Integer.toString(min);
    }
    public String getMax() {
        return max;
    }
    /**
     * Sets the maximum value of the axis.  Determined automatically.
     * @param max maximum value of the axis
     */
    public void setMax(String max) {
        this.max = max;
    }
    /**
     * Sets the maximum numerical value of the axis.  Determined automatically.
     * @param max maximum value of the axis
     */
    public void setMax(int max) {
        this.max = Integer.toString(max);
    }
    public Float getPad() {
        return pad;
    }
    /**
     * Sets a factor multiplied by the data range on the axis to give the
     * axis range so that data points don't fall on the edges of the axis.
     * @param pad factor to be multiplied
     */
    public void setPad(Float pad) {
        this.pad = pad;
    }
    public Tick[] getTicks() {
        return ticks;
    }
    /**
     * Sets array of ticks to use.  Computed automatically.
     * @param ticks array of ticks to use
     */
    public void setTicks(Tick[] ticks) {
        this.ticks = ticks;
    }
    public Integer getNumberTicks() {
        return numberTicks;
    }
    /**
     * Sets desired number of ticks.
     * @param numberTicks number of ticks
     */
    public void setNumberTicks(Integer numberTicks) {
        this.numberTicks = numberTicks;
    }
    public String getRenderer() {
        return renderer;
    }
    /**
     * Sets the renderer to use to draw the axis.  
     * @param renderer renderer to use
     */
    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }
    public IAxisRendererOptions getRendererOptions() {
        return rendererOptions;
    }
    /**
     * Sets options to pass to the renderer  
     * (LinearAxisRenderer has no options).
     * @param rendererOptions renderer options
     */
    public void setRendererOptions(IAxisRendererOptions rendererOptions) {
        this.rendererOptions = rendererOptions;
    }
    /**
     * Gets tick options.
     * @return tick options
     */
    public TickOptions getTickOptions() {
        return tickOptions;
    }
    public Boolean getShowTicks() {
        return showTicks;
    }
    /**
     * Sets whether or not to show the tick labels.
     * @param showTicks true to show the tick labels
     */
    public void setShowTicks(Boolean showTicks) {
        this.showTicks = showTicks;
    }
    public Boolean getShowTickMarks() {
        return showTickMarks;
    }
    public String getTickInterval() {
        return tickInterval;
    }
    /**
     * Sets the number of units between ticks.  Mutually exclusive with 
     * numberTicks.
     * @param tickInterval number of units between ticks
     */
    public void setTickInterval(String tickInterval) {
        this.tickInterval = tickInterval;
    }
    /**
     * Sets the number of units between ticks.  Mutually exclusive with 
     * numberTicks.
     * @param tickInterval number of units between ticks
     */
    public void setTickInterval(int tickInterval) {
        this.tickInterval = Integer.toString(tickInterval);
    }
    /**
     * Sets whether or not to show the tick marks.
     * @param showTickMarks true to show the tick marks
     */
    public void setShowTickMarks(Boolean showTickMarks) {
        this.showTickMarks = showTickMarks;
    }
    public Float getPadMin() {
        return padMin;
    }
    /**
     * Sets minimum padding to extend the range below data bounds.
     * @param padMin padding to extend the range below data bounds
     */
    public void setPadMin(Float padMin) {
        this.padMin = padMin;
    }
    public Float getPadMax() {
        return padMax;
    }
    /**
     * Sets maximum padding to extend the range above data bounds.
     * @param padMax maximum padding to extend the range above data bounds
     */
    public void setPadMax(Float padMax) {
        this.padMax = padMax;
    }
    public String getTickRenderer() {
        return tickRenderer;
    }
    /**
     * Sets a A class of a rendering engine for creating the ticks labels 
     * displayed on the plot
     * @param tickRenderer tick renderer
     */
    public void setTickRenderer(String tickRenderer) {
        this.tickRenderer = tickRenderer;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .raw("renderer", renderer)
            .string("min", min)
            .string("max", max)
            .decimal("pad", pad)
            .decimal("padMin", padMin)
            .decimal("padMax", padMax)
            .rawArray("ticks", ticks)
            .number("numberTicks", numberTicks)
            .string("tickInterval", tickInterval)
            .raw("rendererOptions", rendererOptions)
            .raw("tickRenderer", tickRenderer)
            .raw("tickOptions", tickOptions)
            .bool("showTicks", showTicks)
            .bool("showTickMarks", showTickMarks)
            .toString();
    }
}
