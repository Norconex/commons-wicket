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

/**
 * JQPlot locations.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public enum Location{ 
    NORTH_WEST("nw"), 
    NORTH("n"),
    NORTH_EAST("ne"),
    EAST("e"),
    SOUTH_EAST("se"),
    SOUTH("s"),
    SOUTH_WEST("sw"),
    WEST("w");
    
    final private String abbr;
    private Location(String abbr) {
        this.abbr = abbr;
    }
    public String toString() {
        return abbr;
    };
}