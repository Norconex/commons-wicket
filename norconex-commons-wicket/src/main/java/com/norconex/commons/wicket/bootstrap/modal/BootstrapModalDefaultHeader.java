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

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.behaviors.CssClassAppender;

/**
 * Default Bootstrap modal header.
 * @author Pascal Essiembre
 */
public class BootstrapModalDefaultHeader extends Panel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    private final Label titleLabel;

    public BootstrapModalDefaultHeader(
            String id, IModel<String> title) {
        this(id, title, null);
    }

    public BootstrapModalDefaultHeader(
            String id, IModel<String> title, String fontIcon) {
        super(id);
        this.titleLabel = new Label("modalTitle", title);
        WebMarkupContainer icon = new WebMarkupContainer("icon");
        if (StringUtils.isNotBlank(fontIcon)) {
            icon.add(new CssClassAppender(fontIcon));
        } else {
            icon.setVisible(false);
        }
        add(icon);
    }

    public Label getTitleLabel() {
        return titleLabel;
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(titleLabel);
    }
}
