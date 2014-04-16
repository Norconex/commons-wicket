package com.norconex.commons.wicket.markup.html.chart.jqplot;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("nls")
public class Point<X, Y> implements Serializable {

    private static final long serialVersionUID = 1631601950207740739L;

    private final X x;
    private final Y y;
    
    public Point(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    public X getX() {
        return x;
    }
    public Y getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + convert(x) + ", " + convert(y) + "]";
    }
    private String convert(Object obj) {
        if (obj == null) {
            return "''";
        }
        if (Integer.class.isAssignableFrom(obj.getClass())) {
            return Integer.toString((Integer) obj);
        }
        if (Float.class.isAssignableFrom(obj.getClass())) {
            return Float.toString((Float) obj);
        }
        if (Long.class.isAssignableFrom(obj.getClass())) {
            return Long.toString((Long) obj);
        }
        if (Double.class.isAssignableFrom(obj.getClass())) {
            return Double.toString((Double) obj);
        }
        return "'" + StringUtils.replace(obj.toString(), "'", "\\'") + "'";
    }
}
