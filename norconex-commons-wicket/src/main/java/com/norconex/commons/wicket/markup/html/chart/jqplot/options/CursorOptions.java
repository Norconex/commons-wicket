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
 * JQPlot cursor options
 * @author Pascal Essiembre
 */
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
