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

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Bootstrap modal with a header, content, and footer (using Bootstrap panels).
 * @author Pascal Essiembre
 */
public abstract class BootstrapModalContent extends Panel {

    private static final long serialVersionUID = 3078941000564170354L;

    public BootstrapModalContent(String id) {
        super(id);
    }
    public BootstrapModalContent(String id, IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        addOrReplace(createHeaderComponent("header"));
        addOrReplace(createBodyComponent("body"));
        addOrReplace(createFooterComponent("footer"));
    }

    protected String getCssClass() {
        return "modal fade";
    }
    
    protected abstract Component createHeaderComponent(String id);
    protected abstract Component createBodyComponent(String id);
    protected abstract Component createFooterComponent(String id);
    
}
