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
package com.norconex.commons.wicket.markup.html.chart.jqplot.resources;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Contributes JQPlot javascript and CSS libraries to a page header.
 * @author Pascal Essiembre
 */
public final class JQPlotLibrariesContributor {

    private JQPlotLibrariesContributor() {
        super();
    }

    public static void contribute(IHeaderResponse response) {
        
        renderJS(response, 
            "jquery.jqplot.min.js",
            "jqplot.barRenderer.js",
            "jqplot.pieRenderer.js",
            "jqplot.canvasAxisLabelRenderer.js",
            "jqplot.canvasAxisTickRenderer.js",
            "jqplot.canvasTextRenderer.js",
            "jqplot.cursor.js",
            "jqplot.dateAxisRenderer.js",
            "jqplot.categoryAxisRenderer.js",
            "jqplot.highlighter.js",
            "jqplot.pointLabels.js",
            "jqplot.logAxisRenderer.js",
            "jqplot.enhancedLegendRenderer.js",
            "export-jqplot-to-png.js"
        );
        renderCss(response, "jquery.jqplot.min.css");
    }
    
    private static void renderJS(IHeaderResponse response, String... jsFiles) {
        for (String js : jsFiles) {
            response.render(JavaScriptHeaderItem.forReference(
                    new PackageResourceReference(
                            JQPlotLibrariesContributor.class, js)));
        }
    }
    private static void renderCss(IHeaderResponse response, String... files) {
        for (String css : files) {
            response.render(CssHeaderItem.forReference(
                    new PackageResourceReference(
                            JQPlotLibrariesContributor.class, css)));
        }
    }
}
