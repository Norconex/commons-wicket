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
 * JQPlot Animation options.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class AnimationOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -2973882973228978826L;

    private Boolean show;
    private String direction;
    private Integer speed;
    
    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .string("direction", direction)
            .number("speed", speed)
            .toString();
    }
}
