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

import org.apache.commons.lang3.StringUtils;

/**
 * JQPlot tick. 
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class Tick implements Serializable {

    private static final long serialVersionUID = -789197979622733338L;

    private String value;
    private String label;

    public Tick() {
        super();
    }
    public Tick(String value) {
        super();
        this.value = value;
    }
    public Tick(String value, String label) {
        super();
        this.value = value;
        this.label = label;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        if (value == null) {
            return StringUtils.EMPTY;
        } 
        if (label == null) {
            return "'" + PlotToStringBuilder.esc(value) + "'";
        }
        return "['" + PlotToStringBuilder.esc(value) + "', '" 
                + PlotToStringBuilder.esc(label) + "']";
    }
}
