package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

@SuppressWarnings("nls")
public class AnimationOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -2973882973228978826L;

    private Boolean show;
    private String direction;
    private Integer speed;
    
    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .string("direction", direction)
            .number("speed", speed)
            .toString();
    }
}
