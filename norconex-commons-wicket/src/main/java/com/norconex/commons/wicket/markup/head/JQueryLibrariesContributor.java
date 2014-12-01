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

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.PriorityHeaderItem;

/**
 * Activate Wicket JQuery libraries for general use.
 * @author Pascal Essiembre
 *
 */
public final class JQueryLibrariesContributor {

    private JQueryLibrariesContributor() {
        super();
    }

    public static void contribute(
            Application application, IHeaderResponse response) {
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                .getJQueryReference())));  
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                 .getWicketAjaxReference())));  
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                .getWicketEventReference())));
    }
}
