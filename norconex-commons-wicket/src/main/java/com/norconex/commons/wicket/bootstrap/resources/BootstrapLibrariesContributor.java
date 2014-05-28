package com.norconex.commons.wicket.bootstrap.resources;

import org.apache.wicket.markup.head.IHeaderResponse;

import com.norconex.commons.wicket.markup.head.HeaderContributor;

public final class BootstrapLibrariesContributor {

    private BootstrapLibrariesContributor() {
        super();
    }

    public static void contribute(IHeaderResponse response) {
        HeaderContributor.addCss(
                response, BootstrapLibrariesContributor.class, true, 
                "bootstrap.min-3.1.1.css",
                "bootstrap-theme.min-3.1.1.css",
                "bootstrap-select.min-1.5.4.css",
                "daterangepicker-1.3.5.css",
                "bootstrap.vertical-tabs.min-1.0.0.css",
                "font-awesome.min-4.1.0.css",
                "icomoon.css"
        );
        HeaderContributor.addJavascript(
                response, BootstrapLibrariesContributor.class, true, 
                "bootstrap.min-3.1.1.js",
                "bootstrap-select.min-1.5.4.js",
                "moment.min-2.5.1.js",
                "daterangepicker-1.3.5.js"
        );
    }
}
