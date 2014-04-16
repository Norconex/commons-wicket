package com.norconex.commons.wicket.markup.html.chart.jqplot;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Series<X, Y> extends ArrayList<Point<X, Y>> {

    private static final long serialVersionUID = 7294125463377265352L;

    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "[" + StringUtils.join(this, ", ") + "]";
    }
    
    /**
     * Convenience method for adding a point.
     * @param x x value
     * @param y y value
     * @return true 
     */
    public boolean add(X x, Y y) {
        return add(new Point<X, Y>(x, y));
    }
}
