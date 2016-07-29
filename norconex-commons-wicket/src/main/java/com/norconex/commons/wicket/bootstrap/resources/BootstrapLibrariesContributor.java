/* Copyright 2012-2016 Norconex Inc.
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
 * <p>Add Bootstrap and related Javascript and CSS libraries to a page header.
 * In addition to the Bootstrap-supplied Glyphicons Halflings font icons,
 * Font Awesome and Icomoon are also installed.</p>
 * <p>
 * This class constants represent all resources being contributed.
 * To register components individually, you can instead use the
 * constants with {@link HeaderContributor}
 * </p>
 * @author Pascal Essiembre
 */
public final class BootstrapLibrariesContributor {

    /**
     * Bootstrap CSS version 3.3.6.
     * @see <a href="http://getbootstrap.com">http://getbootstrap.com</a>
     */
    public static final String CSS_BOOTSTRAP = "bootstrap.min-3.3.6.css";
    /**
     * Bootstrap Select CSS version 1.10.0.
     * @see <a href="http://silviomoreto.github.io/bootstrap-select/">
     * http://silviomoreto.github.io/bootstrap-select/</a>
     */
    public static final String CSS_BOOTSTRAP_SELECT = 
            "bootstrap-select.min-1.10.0.css";
    /**
     * Bootstrap Date Range Picker CSS version 2.1.22.
     * @see <a href="http://www.daterangepicker.com">
     * http://www.daterangepicker.com</a>
     */
    public static final String CSS_BOOTSTRAP_DATE_RANGE_PICKER = 
            "daterangepicker-2.1.22.css";
    /**
     * Bootstrap Vertial Tabs CSS version 1.0.0.
     * @see <a href="http://github.com/dbtek/bootstrap-vertical-tabs">
     * http://github.com/dbtek/bootstrap-vertical-tabs</a>
     */
    public static final String CSS_BOOTSTRAP_VERTICAL_TABS = 
            "bootstrap.vertical-tabs.min-1.0.0.css";
    /**
     * Font Awesome CSS version 4.1.0.
     * @see <a href="http://fontawesome.io">http://fontawesome.io</a>
     */
    public static final String CSS_FONT_AWESOME = 
            "font-awesome.min-4.1.0.css";
    /**
     * Font IcoMoon (no version provided).
     * @see <a href="https://icomoon.io/">https://icomoon.io/</a>
     */
    public static final String CSS_ICOMOON = "icomoon.css";
    
    
    /**
     * Bootstrap Javascript version 3.3.6.
     * @see <a href="http://getbootstrap.com">http://getbootstrap.com</a>
     */
    public static final String JS_BOOTSTRAP = "bootstrap.min-3.3.6.js";
    /**
     * Bootstrap Select Javascript version 1.5.4.
     * @see <a href="http://silviomoreto.github.io/bootstrap-select/">
     * http://silviomoreto.github.io/bootstrap-select/</a>
     */
    public static final String JS_BOOTSTRAP_SELECT = 
            "bootstrap-select.min-1.10.0.js";
    /**
     * Bootstrap Date Range Picker Javascript version 2.1.22.
     * @see <a href="http://www.daterangepicker.com">
     * http://www.daterangepicker.com</a>
     */
    public static final String JS_BOOTSTRAP_DATE_RANGE_PICKER = 
            "daterangepicker-2.1.22.js";
    /**
     * Moment.js Javascript version 2.13.0.
     * @see <a href="http://momentjs.com/">http://momentjs.com/</a>
     */
    public static final String JS_MOMENT = 
            "moment.min-2.13.0.js";
    
    //TODO if supporting more langs one day, load them all using the 1 js file.
    /**
     * Moment.js French Locale Javascript version 2.13.0.
     * @see <a href="http://momentjs.com/">http://momentjs.com/</a>
     */
    public static final String JS_MOMENT_LOCALE_FRENCH = 
            "moment-locale-2.13.0-fr-ca.js";
    
    private BootstrapLibrariesContributor() {
        super();
    }

    public static void contribute(IHeaderResponse response) {
        HeaderContributor.addCss(
                response, BootstrapLibrariesContributor.class, true, 
                CSS_BOOTSTRAP,
                CSS_BOOTSTRAP_SELECT,
                CSS_BOOTSTRAP_DATE_RANGE_PICKER,
                CSS_BOOTSTRAP_VERTICAL_TABS,
                CSS_FONT_AWESOME,
                CSS_ICOMOON
        );
        HeaderContributor.addJavascript(
                response, BootstrapLibrariesContributor.class, true, 
                JS_BOOTSTRAP,
                JS_BOOTSTRAP_SELECT,
                JS_MOMENT,
                JS_MOMENT_LOCALE_FRENCH,
                JS_BOOTSTRAP_DATE_RANGE_PICKER
        );
    }
}
