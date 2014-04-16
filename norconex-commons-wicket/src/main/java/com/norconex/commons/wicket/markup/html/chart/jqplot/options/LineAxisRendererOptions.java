package com.norconex.commons.wicket.markup.html.chart.jqplot.options;


/**
 * http://www.jqplot.com/docs/files/jqplot-linearAxisRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class LineAxisRendererOptions implements IAxisRendererOptions {

    private static final long serialVersionUID = -7884794254501503111L;

    private String breakTickLabel;
    private Boolean forceTickAt0;
    private Boolean forceTickAt100; 

    public String getBreakTickLabel() {
        return breakTickLabel;
    }
    /**
     * Sets the label to use at the axis break if breakPoints are specified.
     * @param breakTickLabel label to use
     */
    public void setBreakTickLabel(String breakTickLabel) {
        this.breakTickLabel = breakTickLabel;
    }
    public Boolean getForceTickAt0() {
        return forceTickAt0;
    }
    /**
     * Sets whether to ensure that there is always a tick mark at 0. 
     * @param forceTickAt0 true to ensure that there is always a tick mark at 0
     */
    public void setForceTickAt0(Boolean forceTickAt0) {
        this.forceTickAt0 = forceTickAt0;
    }
    public Boolean getForceTickAt100() {
        return forceTickAt100;
    }
    /**
     * Sets whether to ensure that there is always a tick mark at 100. 
     * @param forceTickAt100 true to ensure that there is always a tick mark at
     *        100
     */
    public void setForceTickAt100(Boolean forceTickAt100) {
        this.forceTickAt100 = forceTickAt100;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .string("breakTickLabel", breakTickLabel)
            .bool("forceTickAt0", forceTickAt0)
            .bool("forceTickAt100", forceTickAt100)
            .toString();
    }
}
