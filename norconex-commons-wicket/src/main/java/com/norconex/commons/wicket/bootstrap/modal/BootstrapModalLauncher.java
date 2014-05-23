package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

// behavior for <button> and <a>
public class BootstrapModalLauncher extends Behavior {

    
    private static final long serialVersionUID = -813364365368794670L;

    private final BootstrapModal modal;
    
    public BootstrapModalLauncher(BootstrapModal modal) {
        super();
        this.modal = modal;
    }
    
    @Override
    public void bind(Component component) {
        super.bind(component);
        component.add(new AttributeModifier("data-toggle", "modal"));
        component.add(new AttributeModifier(
                "data-target", "#" + modal.getMarkupId()));
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        if (!"button".equalsIgnoreCase(tag.getName())
                && !"a".equalsIgnoreCase(tag.getName())) {
            throw new WicketRuntimeException(
                    "BootstrapModalLauncher can only be applied to "
                  + "<button> or <a> tags.");
        }
        super.onComponentTag(component, tag);
    }
}
