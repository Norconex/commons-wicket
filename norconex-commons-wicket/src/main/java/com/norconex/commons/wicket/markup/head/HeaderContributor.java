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
package com.norconex.commons.wicket.markup.head;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Convenience class for making header contributions.
 * @author Pascal Essiembre
 */
public final class HeaderContributor {

    private final IHeaderResponse response;
    
    public HeaderContributor(IHeaderResponse response) {
        super();
        this.response = response;
    }

    public HeaderContributor addJavascript(Class<?> scope, String... jsFiles) {
        addJavascript(response, scope, jsFiles);
        return this;
    }
    public HeaderContributor addCss(Class<?> scope, String... cssFiles) {
        addCss(response, scope, cssFiles);
        return this;
    }

    public static void addJavascript(
            IHeaderResponse response, Class<?> scope, String... jsFiles) {
        addJavascript(response, scope, false, jsFiles);
    }
    public static void addJavascript(
            IHeaderResponse response, Class<?> scope, 
            boolean priority, String... jsFiles) {
        for (String js : jsFiles) {
            HeaderItem item = JavaScriptHeaderItem.forReference(
                    new PackageResourceReference(scope, js));
            if (priority) {
                item = new PriorityHeaderItem(item);
            }
            response.render(item);
        }
    }
    public static void addCss(
            IHeaderResponse response, Class<?> scope, String... cssFiles) {
        addCss(response, scope, false, cssFiles);
    }

    public static void addCss(
            IHeaderResponse response, Class<?> scope, 
            boolean priority, String... cssFiles) {
        for (String css : cssFiles) {
            HeaderItem item = CssHeaderItem.forReference(
                    new PackageResourceReference(scope, css));
            if (priority) {
                item = new PriorityHeaderItem(item);
            }
            response.render(item);
        }
    }
}
