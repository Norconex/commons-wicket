package com.norconex.commons.wicket.bootstrap;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class BootstrapTooltip extends Behavior {

    private static final long serialVersionUID = 2470923030957653822L;

    private final IModel<String> text;
    private final String placement;
    
    public BootstrapTooltip(String text) {
        this(text, "top");
    }
    public BootstrapTooltip(String text, String placement) {
        this(Model.of(text), placement);
    }
    public BootstrapTooltip(IModel<String> text) {
        this(text, "top");
    }
    public BootstrapTooltip(IModel<String> text, String placement) {
        super();
        this.text = text;
        this.placement = placement;
    }
    
    @Override
    public void bind(Component component) {
        component.add(new AttributeModifier("data-toggle", "tooltip"));
        component.add(new AttributeModifier("data-placement", placement));
        component.add(new AttributeModifier("data-original-title", text));
        component.add(new AttributeModifier("title", text));
        component.setOutputMarkupId(true);
    }
    
    @Override
    public void afterRender(Component component) {
        component.getResponse().write("<script>$('#"
                + component.getMarkupId() + "').tooltip();</script>");
    }
}
