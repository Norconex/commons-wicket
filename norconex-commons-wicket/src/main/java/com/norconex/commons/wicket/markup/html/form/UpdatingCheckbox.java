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
package com.norconex.commons.wicket.markup.html.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;

/**
 * A regular checkbox field, which commits its changes after any state
 * change.  
 * @author Pascal Essiembre
 *
 */
public class UpdatingCheckbox extends CheckBox {

    private static final long serialVersionUID = 2947154755264804518L;

    public UpdatingCheckbox(String id, IModel<Boolean> model) {
        super(id, model);
    }
    public UpdatingCheckbox(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new OnChangeAjaxBehavior() {
            private static final long serialVersionUID = 2483719054190303122L;
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                onChange(target);
            }
        });
    }

    /**
     * Call when javascript event "onblur" occurs on this check field.
     * It is meant to be overwritten.  Default implementation does nothing.
     * @param target Ajax request target
     */
    protected void onChange(AjaxRequestTarget target) {
        // does nothing by default
    }
}
