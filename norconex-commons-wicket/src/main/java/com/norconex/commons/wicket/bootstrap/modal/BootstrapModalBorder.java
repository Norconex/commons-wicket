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
package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.behaviors.CssClass;

/**
 * Wicket {@link Border} for a Bootstrap Modal Dialog.
 * @author Pascal Essiembre
 */
public class BootstrapModalBorder extends Border {

    private static final long serialVersionUID = -8728019309993703575L;

    private final WebMarkupContainer dialog = new WebMarkupContainer("dialog");

    public BootstrapModalBorder(String id) {
        super(id);
    }
    public BootstrapModalBorder(String id, IModel<?> model) {
        super(id, model);
    }
    
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(new AttributeModifier("tabindex", "-1"));
        add(new AttributeModifier("role", "dialog"));
        add(new AttributeModifier("aria-hidden", "true"));
        add(new CssClass(getBorderCssClass()));
        dialog.add(new CssClass(getDialogCssClass()));
        addToBorder(dialog);
    }

    protected String getBorderCssClass() {
        return "modal fade";
    }
    
    protected String getDialogCssClass() {
        return "modal-dialog";
    }
}
