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
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.markup.html.panel.CssPanel;

/**
 * Bootstrap Modal dialog.
 * @author Pascal Essiembre
 */
public abstract class BootstrapModal extends CssPanel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    private final IModel<String> title;
    private final BootstrapModalBorder border;

    public BootstrapModal(
            String id, IModel<String> title, IModel<?> model) {
        this(id, title, model, false);
    }
    public BootstrapModal(String id, IModel<String> title) {
        this(id, title, false);
    }
    public BootstrapModal(String id, IModel<String> title, boolean large) {
        this(id, title, null, large);
    }
    public BootstrapModal(
            String id, IModel<String> title, IModel<?> model, 
            final boolean large) {
        super(id, model);
        this.title = title;
        border = createModalBorder("modal", large);
    }
    
    protected BootstrapModalBorder createModalBorder(
            String markupId, boolean large) {
        return new BootstrapModalBorder(markupId, large);
    }
    
    public BootstrapModalBorder getBorder() {
        return border;
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        border.add(createContentComponent("content"));
        add(border);
    }

    public IModel<String> getTitle() {
        return title;
    }
    
    protected Component createContentComponent(String markupId) {
        return new BootstrapModalContent(markupId) {
            private static final long serialVersionUID = 5962119343584469411L;
            @Override
            protected Component createHeaderComponent(String id) {
                return BootstrapModal.this.createHeaderComponent(id);
            }
            @Override
            protected Component createBodyComponent(String id) {
                return BootstrapModal.this.createBodyComponent(id);
            }
            @Override
            protected Component createFooterComponent(String id) {
                return BootstrapModal.this.createFooterComponent(id);
            }
        };
    }
    
    protected Component createHeaderComponent(String id) {
        BootstrapModalDefaultHeader header = 
                new BootstrapModalDefaultHeader(id, title);
        getBorder().add(new AttributeModifier(
                "aria-labelledby", header.getTitleLabel().getMarkupId()));
        return header;
    }
    protected abstract Component createBodyComponent(String id);
    protected Component createFooterComponent(String id) {
        return new BootstrapModalDefaultFooter(id);
    }
}
