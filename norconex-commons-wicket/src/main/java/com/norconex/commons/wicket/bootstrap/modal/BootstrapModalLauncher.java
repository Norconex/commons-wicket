package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

import com.norconex.commons.wicket.behaviors.OnClickBehavior;

// behavior for <button> and <a>
public class BootstrapModalLauncher extends Behavior {

    
    private static final long serialVersionUID = -813364365368794670L;

    private final String modalId;
    private final BootstrapAjaxModal ajaxModal;
    
    public BootstrapModalLauncher(BootstrapModal modal) {
        super();
        this.modalId = modal.getBorder().getMarkupId();
        if (modal instanceof BootstrapAjaxModal) {
            this.ajaxModal = (BootstrapAjaxModal) modal;
        } else {
            this.ajaxModal = null;
        }
    }
    public BootstrapModalLauncher(BootstrapModalBorder modalBorder) {
        super();
        this.modalId = modalBorder.getMarkupId();
        this.ajaxModal = null;
    }
    
    @Override
    public void bind(Component component) {
        super.bind(component);
        if (ajaxModal == null) {
            component.add(new AttributeModifier("data-toggle", "modal"));
            component.add(new AttributeModifier(
                    "data-target", "#" + modalId));
        } else {
            component.add(new OnClickBehavior() {
                private static final long serialVersionUID = 
                        6557766895096073292L;
                @Override
                protected void onClick(AjaxRequestTarget target) {
                    ajaxModal.show(target);
                }
            });
        }
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
