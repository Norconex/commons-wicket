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
package com.norconex.commons.wicket.markup.html.chart.jqplot;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * A JQPlot point.
 * @author Pascal Essiembre
 *
 * @param <X>
 *    x-axis type
 * @param <Y>
 *    y-axis type
 */
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
