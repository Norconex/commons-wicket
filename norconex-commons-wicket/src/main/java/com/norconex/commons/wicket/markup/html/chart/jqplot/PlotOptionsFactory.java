package com.norconex.commons.wicket.markup.html.chart.jqplot;

import com.norconex.commons.wicket.markup.html.chart.jqplot.options.AxisOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.BarRendererOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.BarRendererOptions.Direction;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.GridOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.HighlighterOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.HighlighterOptions.TooltipAxes;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.LegendOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.LineAxisRendererOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.LineRendererOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.Location;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.PieRendererOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.PlotOptions;
import com.norconex.commons.wicket.markup.html.chart.jqplot.options.SeriesOptions;


@SuppressWarnings("nls")
public final class PlotOptionsFactory {

    public static final int DEFAULT_ANIMATION_SPEED = 2000; 
    
    private PlotOptionsFactory() {
        super();
    }

    public static PlotOptions createPieChart() {
        //PlotOptions p = createCommonBasePlot();
        PlotOptions p = new PlotOptions();
        p.setAnimate(true);
        p.setCaptureRightClick(true);
        p.getCursor().setShow(false);
        
        p.getSeriesDefaults().setRenderer(SeriesOptions.PIE_RENDERER);

        PieRendererOptions pieRenderer = new PieRendererOptions();
        pieRenderer.setPadding(8);
        pieRenderer.setSliceMargin(4);
        pieRenderer.setShowDataLabels(true);
        pieRenderer.setHighlightMouseOver(true);
        
        p.getSeriesDefaults().setRendererOptions(pieRenderer);
        
        LegendOptions legendOptions = p.getLegend();
        legendOptions.setShow(true);
        
        
//        HighlighterOptions hl = p.getHighlighter();
//        hl.setShow(true);
        
//        BarRendererOptions barRenderer = new BarRendererOptions();
//        barRenderer.getAnimation().setSpeed(DEFAULT_ANIMATION_SPEED);
//        barRenderer.setBarDirection(Direction.horizontal);
//        p.getSeriesDefaults().setRendererOptions(barRenderer);
//
//        p.getGrid().setDrawGridLines(false);
//        p.getAxes().getYaxis().setRenderer(AxisOptions.CATEGORY_AXIS_RENDERER);
//        p.getHighlighter().setShow(false);
        return p;
    }
    
    public static PlotOptions createStackedHorizontalBarChart() {
        PlotOptions p = createHorizontalBarChart();
        p.setStackSeries(true);
        p.getSeriesDefaults().setShadowAngle(135);
        p.getSeriesDefaults().getPointLabels().setShow(true);
        p.getSeries().get(0).getPointLabels().setShow(false);
        p.getSeries().get(1).setColor("#ddeeff");
        
        HighlighterOptions hl = p.getHighlighter();
        hl.setShow(true);
        hl.setFormatString("%s");
        hl.setShowTooltip(true);
        hl.setSizeAdjust(7.5f);
        hl.setYvalues(1);
        hl.setUseAxesFormatters(true);
        hl.setTooltipAxes(TooltipAxes.both);
        hl.setTooltipLocation(Location.NORTH_EAST);
        return p;
    }

    
    public static PlotOptions createHorizontalBarChart() {
        PlotOptions p = createCommonBasePlot();
        p.getSeriesDefaults().setRenderer(SeriesOptions.BAR_RENDERER);

        BarRendererOptions barRenderer = new BarRendererOptions();
        barRenderer.getAnimation().setSpeed(DEFAULT_ANIMATION_SPEED);
        barRenderer.setBarDirection(Direction.horizontal);
        p.getSeriesDefaults().setRendererOptions(barRenderer);

        p.getGrid().setDrawGridLines(false);
        p.getAxes().getYaxis().setRenderer(AxisOptions.CATEGORY_AXIS_RENDERER);
        p.getHighlighter().setShow(false);
        return p;
    }
    
    public static PlotOptions createVertialBarChart() {
        PlotOptions p = createCommonBasePlot();
        p.getSeriesDefaults().setRenderer(SeriesOptions.BAR_RENDERER);
        BarRendererOptions barRenderer = new BarRendererOptions();
        barRenderer.getAnimation().setSpeed(DEFAULT_ANIMATION_SPEED);
        p.getSeriesDefaults().setRendererOptions(barRenderer);
        p.getGrid().setDrawGridLines(false);
        p.getAxes().getXaxis().setRenderer(AxisOptions.CATEGORY_AXIS_RENDERER);
        p.getHighlighter().setShow(false);
        return p;
    }

    public static PlotOptions createLineChart() {
        PlotOptions p = createCommonBasePlot();

        p.getGrid().setDrawGridLines(true);
        p.getAxes().getXaxis().setRenderer(AxisOptions.CATEGORY_AXIS_RENDERER);
        
        LineAxisRendererOptions rendererOptions = 
                new LineAxisRendererOptions(); 
        rendererOptions.setForceTickAt0(true);
        AxisOptions yaxis = p.getAxes().getYaxis();
        yaxis.setRendererOptions(rendererOptions);
        yaxis.setPad(0f);
        yaxis.setPadMin(0f);
        yaxis.getTickOptions().setFormatString("%.0f");

        HighlighterOptions hl = p.getHighlighter();
        hl.setShowTooltip(true);
        hl.setTooltipLocation(Location.NORTH);
        hl.setSizeAdjust(7.5f);
        hl.setYvalues(1);
        hl.setUseAxesFormatters(true);
        hl.setTooltipAxes(TooltipAxes.both);
        hl.setFormatString("%s: %s");
        
        LineRendererOptions lineOptions = new LineRendererOptions();
        lineOptions.getAnimation().setSpeed(DEFAULT_ANIMATION_SPEED);
        p.getSeriesDefaults().setRendererOptions(lineOptions);
        p.getSeriesDefaults().getPointLabels().setShow(false);
        
        return p;
    }
    public static PlotOptions createFilledLineChart() {
        PlotOptions p = createLineChart();
        SeriesOptions series1 = p.getSeries().get(0);
        series1.setShadow(false);
        series1.setFill(true);
        series1.setFillAndStroke(true);
        series1.setFillAlpha(0.2f);
        SeriesOptions series2 = p.getSeries().get(1);
        series2.setShadow(false);
        series2.setFill(true);
        series2.setFillAndStroke(true);
        series2.setFillColor("#FFDD66");
        series2.setFillAlpha(0.7f);
        return p;
    }

    private static PlotOptions createCommonBasePlot() {
        PlotOptions p = new PlotOptions();
        p.setAnimate(true);
        p.setCaptureRightClick(true);
        p.getCursor().setShow(false);
        
        GridOptions grid = p.getGrid();
        grid.setGridLineColor("#eeeeee");
        grid.setBackground("#ffffff");
        grid.setBorderColor("#999999");
        grid.setBorderWidth(1.0f);
        
        SeriesOptions series1 = new SeriesOptions();
        series1.setColor("#6997c7");
        p.addSeries(series1);
        SeriesOptions series2 = new SeriesOptions();
        series2.setColor("#FFAA22");
        p.addSeries(series2);
        
        return p;
    }
}
