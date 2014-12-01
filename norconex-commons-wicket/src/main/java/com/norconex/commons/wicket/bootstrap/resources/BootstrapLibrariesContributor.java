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
package com.norconex.commons.wicket.bootstrap.resources;

import org.apache.wicket.markup.head.IHeaderResponse;

import com.norconex.commons.wicket.markup.head.HeaderContributor;

/**
 * Add bootstrap javascript and CSS libraries to a page header.
 * In addition to the Bootstrap-supplied Glyphicons Halflings font icons,
 * Font Awesome and Icomoon are also installed.
 * @author Pascal Essiembre
 */
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
