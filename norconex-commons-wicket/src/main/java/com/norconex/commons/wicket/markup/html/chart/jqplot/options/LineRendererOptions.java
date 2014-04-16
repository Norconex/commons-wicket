package com.norconex.commons.wicket.markup.html.chart.jqplot.options;


/**
 * http://www.jqplot.com/docs/files/jqplot-lineRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class LineRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -279474992413622308L;

    private final AnimationOptions animation = new AnimationOptions();
    
    
    
    /*
    highlightMouseOver  True to highlight area on a filled plot when moused over.
    highlightMouseDown      True to highlight when a mouse button is pressed over an area on a filled plot.
    highlightColor  color to use when highlighting an area on a filled plot.
    */

    public AnimationOptions getAnimation() {
        return animation;
    }



    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .toString();
    }
}
