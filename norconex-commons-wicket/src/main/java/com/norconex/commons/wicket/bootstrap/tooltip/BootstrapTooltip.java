package com.norconex.commons.wicket.bootstrap.tooltip;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class BootstrapTooltip extends Behavior {

    private static final long serialVersionUID = 2470923030957653822L;

    public enum Placement{ TOP, RIGHT, BOTTOM, LEFT, AUTO }
    
    private final IModel<String> text;
    private final Placement placement;
    
    public BootstrapTooltip(String text) {
        this(text, Placement.AUTO);
    }
    public BootstrapTooltip(String text, Placement placement) {
        this(Model.of(text), placement);
    }
    public BootstrapTooltip(IModel<String> text) {
        this(text, Placement.AUTO);
    }
    public BootstrapTooltip(IModel<String> text, Placement placement) {
        super();
        this.text = text;
        this.placement = placement;
    }
    
    @Override
    public void bind(Component component) {
        if (text != null) {
            String p = null;
            if (placement == null) {
                p = Placement.AUTO.toString().toLowerCase();
            } else {
                p = placement.toString().toLowerCase();
            }
            component.add(new AttributeModifier("data-toggle", "tooltip"));
            component.add(new AttributeModifier("data-placement", p));
            component.add(new AttributeModifier("data-original-title", text));
            component.add(new AttributeModifier("title", text));
            component.setOutputMarkupId(true);
        }
    }
    
    @Override
    public void afterRender(Component component) {
        if (text != null) {
            component.getResponse().write("<script>$('#"
                    + component.getMarkupId()
                    + "').tooltip({ container: 'body' });</script>");
        }
    }
}
