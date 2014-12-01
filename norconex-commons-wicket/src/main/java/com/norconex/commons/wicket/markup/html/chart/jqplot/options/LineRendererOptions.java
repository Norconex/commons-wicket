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
 * JQPlot line renderer options.
 * http://www.jqplot.com/docs/files/jqplot-lineRenderer-js.html
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class LineRendererOptions implements ISeriesRendererOptions {

    private static final long serialVersionUID = -279474992413622308L;

    private final AnimationOptions animation = new AnimationOptions();
    
    
    
    /*
    highlightMouseOver  True to highlight area on a filled plot when moused over.
    highlightMouseDown      True to highlight when a mouse button is pressed over an area on a filled plot.
    highlightColor  color to use when highlighting an area on a filled plot.
    */

    public AnimationOptions getAnimation() {
        return animation;
    }



    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .raw("animation", animation)
            .toString();
    }
}
