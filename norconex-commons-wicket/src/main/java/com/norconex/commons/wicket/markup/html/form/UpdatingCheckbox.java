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
