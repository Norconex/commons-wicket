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
package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;

import com.norconex.commons.wicket.behaviors.CssClassAppender;

/**
 * Wicket {@link Border} for a Bootstrap Modal Dialog.
 * @author Pascal Essiembre
 */
public class BootstrapModalBorder extends Border {

    private static final long serialVersionUID = -8728019309993703575L;

    private final WebMarkupContainer dialog = new WebMarkupContainer("dialog");

    private final boolean large;
    
    public BootstrapModalBorder(String id) {
        this(id, false);
    }
    public BootstrapModalBorder(String id, IModel<?> model) {
        this(id, model, false);
    }
    public BootstrapModalBorder(String id, boolean large) {
        super(id);
        this.large = large;
    }
    public BootstrapModalBorder(String id, IModel<?> model, boolean large) {
        super(id, model);
        this.large = large;
    }
    
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(new AttributeModifier("tabindex", "-1"));
        add(new AttributeModifier("role", "dialog"));
        add(new AttributeModifier("aria-hidden", "true"));
        add(new CssClassAppender(getModalBorderCssClass()));
        dialog.add(new CssClassAppender(getDialogCssClass()));
        addToBorder(dialog);
    }

    protected String getModalBorderCssClass() {
        return "modal-vertical-centered modal fade";
    }
    
    protected String getDialogCssClass() {
        String css = "modal-dialog"; 
        if (large) {
            css += " modal-lg";
        }
        return css;
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(
                new CssResourceReference(getClass(), 
                        "BootstrapModalBorder.css")));        
    }
}
