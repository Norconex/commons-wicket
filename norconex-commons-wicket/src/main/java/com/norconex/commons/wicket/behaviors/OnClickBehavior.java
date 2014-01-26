package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

@SuppressWarnings("nls")
public abstract class OnClickBehavior extends AjaxEventBehavior {

    private static final long serialVersionUID = 4753399421269066084L;

    public OnClickBehavior() {
        super("onclick");
    }

    @Override
    protected final void onEvent(AjaxRequestTarget target) {
        onClick(target);
    }

    protected abstract void onClick(AjaxRequestTarget target);
    
}