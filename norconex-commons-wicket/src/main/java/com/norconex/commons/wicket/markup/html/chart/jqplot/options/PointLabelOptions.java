/* Copyright 2012-2016 Norconex Inc.
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
 * JQPlot point label options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class PointLabelOptions implements Serializable {

    private static final long serialVersionUID = -5694677178788650146L;

    private Boolean show;
    private Boolean hideZeros;
    private Location location;

    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether to show the labels or not.
     * @param show true to show labels
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public Location getLocation() {
        return location;
    }
    /**
     * Sets the compass location where to position the label around the point.
     * @param location the label position
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
    /**
     * Sets whether not show a label for a value which is 0. 
     * @param hideZeros true to hide zeros
     */
    public void setHideZeros(Boolean hideZeros) {
        this.hideZeros = hideZeros;
    }
    public Boolean getHideZeros() {
        return hideZeros;
    }
    
    
    /*

Others:

labelsFromSeries        true to use labels within data point arrays.
seriesLabelIndex        array index for location of labels within data point arrays.
labels  array of arrays of labels, one array for each series.
stackedValue    true to display value as stacked in a stacked plot.
ypadding        vertical padding in pixels between point and label
xpadding        horizontal padding in pixels between point and label
escapeHTML      true to escape html entities in the labels.
edgeTolerance   Number of pixels that the label must be away from an axis boundary in order to be drawn.
formatter       A class of a formatter for the tick text.
formatString    string passed to the formatter.


     */
    
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .bool("hideZeros", hideZeros)
            .enumString("location", location)
            .toString();
    }
}
