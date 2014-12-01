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
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

/**
 * A regular text field, which commits its changes upon encountering
 * an "onblur" event.  I also supports being marked as required from
 * the constructor.
 * @author Pascal Essiembre
 *
 * @param <T> The underlying model object type
 */
public class UpdatingTextField<T> extends TextField<T> {

    private static final long serialVersionUID = -5175461279206209443L;

    public UpdatingTextField(String id) {
        this(id, false);
    }
    public UpdatingTextField(String id, boolean required) {
        this(id, null, null, required);
    }
    public UpdatingTextField(String id, Class<T> type) {
        this(id, null, type, false);
    }
    public UpdatingTextField(String id, IModel<T> model, Class<T> type) {
        this(id, model, type, false);
    }
    public UpdatingTextField(String id, IModel<T> model) {
        this(id, model, false);
    }
    public UpdatingTextField(
            String id, IModel<T> model, boolean required) {
        this(id, model, null, required);
    }
    public UpdatingTextField(
            String id, IModel<T> model, Class<T> type, boolean required) {
        super(id, model, type);
        setRequired(required);
        add(new AjaxFormComponentUpdatingBehavior("onblur") { //$NON-NLS-1$
            private static final long serialVersionUID = 5740741138964723447L;
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                onBlur(target);
            }
        });
    }
    /**
     * Call when javascript event "onblur" occurs on this text field.
     * It is meant to be overwritten.  Default implementation does nothing.
     * @param target Ajax request target
     */
    protected void onBlur(AjaxRequestTarget target) {
        // does nothing by default
    }
}
