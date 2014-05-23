package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.behaviors.CssClass;

public class BootstrapModalBorder extends Border {

    private static final long serialVersionUID = -8728019309993703575L;

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
        add(new CssClass(getCssClass()));
    }

    protected String getCssClass() {
        return "modal fade";
    }
}
