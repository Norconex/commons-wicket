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
package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;

/**
 * JQPlot axes.
 * @author Pascal Essiembre
 *
 */
@SuppressWarnings("nls")
public class Axes implements Serializable {

    private static final long serialVersionUID = -6421729329151316971L;

    private final AxisOptions xaxis = new AxisOptions();
    private final AxisOptions yaxis = new AxisOptions();
    private final AxisOptions x2axis = new AxisOptions();
    private final AxisOptions y2axis = new AxisOptions();
    
    public AxisOptions getXaxis() {
        return xaxis;
    }
    public AxisOptions getYaxis() {
        return yaxis;
    }
    public AxisOptions getX2axis() {
        return x2axis;
    }
    public AxisOptions getY2axis() {
        return y2axis;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("xaxis", xaxis)
            .raw("yaxis", yaxis)
            .raw("x2axis", x2axis)
            .raw("y2axis", y2axis)
            .toString();
    }
}
