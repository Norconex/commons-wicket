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

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

/**
 * JQPlot series.
 * @author Pascal Essiembre
 *
 * @param <X>
 *    x-axis type
 * @param <Y>
 *    y-axis type
 */
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
