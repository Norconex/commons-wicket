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
package com.norconex.commons.wicket.markup.html;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResource;

/**
 * A {@link WebPage}  automatically contributing to header any "*.css" files
 * with the same name as the page, or having the name 
 * "wicket-package.css". 
 * @author Pascal Essiembre
 */
public class CssPage extends WebPage {

    private static final long serialVersionUID = 8392039175585199543L;

    public CssPage() {
        super();
    }
    public CssPage(IModel<?> model) {
        super(model);
    }
    public CssPage(PageParameters parameters) {
        super(parameters);
    }

 
    @SuppressWarnings("nls")
    @Override
    public void renderHead(IHeaderResponse response) {
        // Start local and go up to super classes to find a CSS that matches
        // the class name.
        String css = getClass().getSimpleName() + ".css";
        boolean found = exists(getClass(), css);
        if (!found) {
            css = "wicket-package.css";
            found = exists(getClass(), css);
        }
        if (found) {
            response.render(CssHeaderItem.forReference(
                    new CssResourceReference(getClass(), css)));
        }            
    }
    
    protected final boolean exists(
            Class<?> targetClass, String packageFileName) {
        return PackageResource.exists(
                targetClass, packageFileName, 
                getLocale(), getStyle(), getVariation());
    }

}
