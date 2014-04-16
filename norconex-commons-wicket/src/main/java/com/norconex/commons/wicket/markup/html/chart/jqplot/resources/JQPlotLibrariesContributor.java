package com.norconex.commons.wicket.markup.html.chart.jqplot.resources;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

public final class JQPlotLibrariesContributor {

    private JQPlotLibrariesContributor() {
        super();
    }

    public static void contribute(IHeaderResponse response) {
        
        renderJS(response, 
            "jquery.jqplot.min.js",
            "jqplot.barRenderer.min.js",
            "jqplot.canvasAxisLabelRenderer.min.js",
            "jqplot.canvasAxisTickRenderer.min.js",
            "jqplot.canvasTextRenderer.min.js",
            "jqplot.cursor.min.js",
            "jqplot.dateAxisRenderer.min.js",
            "jqplot.highlighter.min.js",
            "jqplot.pieRenderer.min.js",
            "jqplot.pointLabels.min.js",
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
