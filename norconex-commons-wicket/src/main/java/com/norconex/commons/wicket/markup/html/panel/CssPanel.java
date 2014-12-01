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
package com.norconex.commons.wicket.markup.html.panel;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResource;

/**
 * Panel automatically contributing to header any "*.css" files
 * with the same name as the panel, or having the name 
 * "wicket-package.css".  If no CSS is found it will look at the 
 * parent component hierarchy until one is found (if any).
 * @author Pascal Essiembre
 */
public abstract class CssPanel extends Panel {

    private static final long serialVersionUID = -5248495555892117265L;

    public CssPanel(String id, IModel<?> model) {
        super(id, model);
    }

    public CssPanel(String id) {
        super(id);
    }

    
    @SuppressWarnings("nls")
    @Override
    public void renderHead(IHeaderResponse response) {
        // Start local and go up to super classes to find a CSS that matches
        // the class name.
        Class<?> targetClass = this.getClass();
        do {
            String css = targetClass.getSimpleName() + ".css";
            boolean found = exists(targetClass, css);
            if (!found) {
                css = "wicket-package.css";
                found = exists(targetClass, css);
            }
            if (found) {
                response.render(CssHeaderItem.forReference(
                        new CssResourceReference(targetClass, css)));
                break; // really break, or add them all???
            }            
        } while ((targetClass = targetClass.getSuperclass()) != null);
    }
    
    protected final boolean exists(
            Class<?> targetClass, String packageFileName) {
        return PackageResource.exists(
                targetClass, packageFileName, 
                getLocale(), getStyle(), getVariation());
    }
    
}
