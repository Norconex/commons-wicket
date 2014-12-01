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
 * JQPlot line axis renderer options.
 * http://www.jqplot.com/docs/files/jqplot-linearAxisRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class LineAxisRendererOptions implements IAxisRendererOptions {

    private static final long serialVersionUID = -7884794254501503111L;

    private String breakTickLabel;
    private Boolean forceTickAt0;
    private Boolean forceTickAt100; 

    public String getBreakTickLabel() {
        return breakTickLabel;
    }
    /**
     * Sets the label to use at the axis break if breakPoints are specified.
     * @param breakTickLabel label to use
     */
    public void setBreakTickLabel(String breakTickLabel) {
        this.breakTickLabel = breakTickLabel;
    }
    public Boolean getForceTickAt0() {
        return forceTickAt0;
    }
    /**
     * Sets whether to ensure that there is always a tick mark at 0. 
     * @param forceTickAt0 true to ensure that there is always a tick mark at 0
     */
    public void setForceTickAt0(Boolean forceTickAt0) {
        this.forceTickAt0 = forceTickAt0;
    }
    public Boolean getForceTickAt100() {
        return forceTickAt100;
    }
    /**
     * Sets whether to ensure that there is always a tick mark at 100. 
     * @param forceTickAt100 true to ensure that there is always a tick mark at
     *        100
     */
    public void setForceTickAt100(Boolean forceTickAt100) {
        this.forceTickAt100 = forceTickAt100;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .string("breakTickLabel", breakTickLabel)
            .bool("forceTickAt0", forceTickAt0)
            .bool("forceTickAt100", forceTickAt100)
            .toString();
    }
}
