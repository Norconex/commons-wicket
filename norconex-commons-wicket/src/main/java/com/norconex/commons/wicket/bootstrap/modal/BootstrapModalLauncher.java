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
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

import com.norconex.commons.wicket.behaviors.OnClickBehavior;

/**
 * Behavior to associate a Bootstrap modal dialog to a link or button.
 * This behavior must be attached to either &lt;button&gt; or &lt;a&gt;.
 * @author Pascal Essiembre
 */
public class BootstrapModalLauncher extends Behavior {

    
    private static final long serialVersionUID = -813364365368794670L;

    private final String modalId;
    private final BootstrapAjaxModal ajaxModal;
    
    public BootstrapModalLauncher(BootstrapModal modal) {
        super();
        this.modalId = modal.getBorder().getMarkupId();
        if (modal instanceof BootstrapAjaxModal) {
            this.ajaxModal = (BootstrapAjaxModal) modal;
        } else {
            this.ajaxModal = null;
        }
    }
    public BootstrapModalLauncher(BootstrapModalBorder modalBorder) {
        super();
        this.modalId = modalBorder.getMarkupId();
        this.ajaxModal = null;
    }
    
    @Override
    public void bind(Component component) {
        super.bind(component);
        if (ajaxModal == null) {
            component.add(new AttributeModifier("data-toggle", "modal"));
            component.add(new AttributeModifier(
                    "data-target", "#" + modalId));
        } else {
            component.add(new OnClickBehavior() {
                private static final long serialVersionUID = 
                        6557766895096073292L;
                @Override
                protected void onClick(AjaxRequestTarget target) {
                    ajaxModal.show(target);
                }
            });
        }
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        if (!"button".equalsIgnoreCase(tag.getName())
                && !"a".equalsIgnoreCase(tag.getName())) {
            throw new WicketRuntimeException(
                    "BootstrapModalLauncher can only be applied to "
                  + "<button> or <a> tags.");
        }
        super.onComponentTag(component, tag);
    }
}
