package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

@SuppressWarnings("nls")
public class CursorOptions implements Serializable {

    private static final long serialVersionUID = -246789089732530817L;

    private String style;
    private Boolean show;

    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }

    // There are more attributes, see jqplot.com
    
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .string("style", style)
            .bool("show", show)
            .toString();
    }
}
