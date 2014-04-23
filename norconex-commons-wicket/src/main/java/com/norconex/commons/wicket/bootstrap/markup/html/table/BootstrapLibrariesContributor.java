package com.norconex.commons.wicket.bootstrap.markup.html.table;

import org.apache.wicket.markup.head.IHeaderResponse;

public final class BootstrapLibrariesContributor {

    private BootstrapLibrariesContributor() {
        super();
    }

    public static void contribute(IHeaderResponse response) {
        
        //TODO
        
//        renderJS(response, 
//            "jquery.jqplot.min.js",
//            "jqplot.barRenderer.min.js",
//            "jqplot.pieRenderer.min.js",
//            "jqplot.canvasAxisLabelRenderer.min.js",
//            "jqplot.canvasAxisTickRenderer.min.js",
//            "jqplot.canvasTextRenderer.min.js",
//            "jqplot.cursor.min.js",
//            "jqplot.dateAxisRenderer.min.js",
//            "jqplot.categoryAxisRenderer.min.js",
//            "jqplot.highlighter.min.js",
//            "jqplot.pointLabels.min.js",
//            "jqplot.logAxisRenderer.min.js",
//            "export-jqplot-to-png.js"
//        );
//        renderCss(response, "jquery.jqplot.min.css");
    }
//    
//    private static void renderJS(IHeaderResponse response, String... jsFiles) {
//        for (String js : jsFiles) {
//            response.render(JavaScriptHeaderItem.forReference(
//                    new PackageResourceReference(
//                            BootstrapLibrariesContributor.class, js)));
//        }
//    }
//    private static void renderCss(IHeaderResponse response, String... files) {
//        for (String css : files) {
//            response.render(CssHeaderItem.forReference(
//                    new PackageResourceReference(
//                            BootstrapLibrariesContributor.class, css)));
//        }
//    }
}
