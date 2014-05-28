package com.norconex.commons.wicket.markup.html.form;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

/**
 * A regular drop down choice, which commits its changes upon encountering
 * an "onchange" event. 
 * @author Pascal Essiembre
 *
 * @param <T> The underlying model object type
 */
public class UpdatingDropDownChoice<T> extends DropDownChoice<T> {

    private static final long serialVersionUID = -8747705310404796050L;

    public UpdatingDropDownChoice(String id,
            IModel<? extends List<? extends T>> choices,
            IChoiceRenderer<? super T> renderer) {
        super(id, choices, renderer);
    }
    public UpdatingDropDownChoice(String id, IModel<T> model,
            IModel<? extends List<? extends T>> choices,
            IChoiceRenderer<? super T> renderer) {
        super(id, model, choices, renderer);
    }
    public UpdatingDropDownChoice(String id, IModel<T> model,
            IModel<? extends List<? extends T>> choices) {
        super(id, model, choices);
    }
    public UpdatingDropDownChoice(String id, IModel<T> model,
            List<? extends T> data, IChoiceRenderer<? super T> renderer) {
        super(id, model, data, renderer);
    }
    public UpdatingDropDownChoice(String id, IModel<T> model,
            List<? extends T> choices) {
        super(id, model, choices);
    }
    public UpdatingDropDownChoice(String id, List<? extends T> data,
            IChoiceRenderer<? super T> renderer) {
        super(id, data, renderer);
    }
    public UpdatingDropDownChoice(String id, List<? extends T> choices) {
        super(id, choices);
    }
    public UpdatingDropDownChoice(String id) {
        super(id);
    }

    /**
     * Call when javascript event "onchange" occurs on this text field.
     * It is meant to be overwritten.  Default implementation does nothing.
     * @param target Ajax request target
     */
    protected void onChange(AjaxRequestTarget target) {
        // does nothing by default
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AjaxFormComponentUpdatingBehavior("onchange") {
            private static final long serialVersionUID = -1443172413260581043L;
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                onChange(target);
            }
        });
    }
}
