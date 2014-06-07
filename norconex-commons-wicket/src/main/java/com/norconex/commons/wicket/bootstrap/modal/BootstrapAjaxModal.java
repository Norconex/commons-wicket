package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;

public abstract class BootstrapAjaxModal extends BootstrapModal {

    private static final long serialVersionUID = 6038329709701913062L;

    private boolean loadContent = false;
    
    public BootstrapAjaxModal(
            String id, IModel<String> title, IModel<?> model) {
        super(id, title, model);
    }
    public BootstrapAjaxModal(String id, IModel<String> title) {
        super(id, title);
    }

    public String getModalId() {
        return getBorder().getMarkupId();
    }
    
    @Override
    protected void onBeforeRender() {
        getBorder().addOrReplace(createContentComponent("content"));
        addOrReplace(getBorder());
        super.onBeforeRender();
    }
    
    protected String getCssClass() {
        return "modal fade";
    }
    protected final Component createContentComponent(String markupId) {
        if (loadContent) {
            return createAjaxContentComponent(markupId);
        } else {
            return new EmptyPanel(markupId);
        }
    }
    
    protected Component createAjaxContentComponent(String markupId) {
        return new BootstrapModalContent(markupId) {
            private static final long serialVersionUID = 5962119343584469411L;
            @Override
            protected Component createHeaderComponent(String id) {
                return BootstrapAjaxModal.this.createHeaderComponent(id);
            }
            @Override
            protected Component createBodyComponent(String id) {
                return BootstrapAjaxModal.this.createBodyComponent(id);
            }
            @Override
            protected Component createFooterComponent(String id) {
                return BootstrapAjaxModal.this.createFooterComponent(id);
            }
        };
    }
    
    
    public void show(AjaxRequestTarget target) {
        loadContent = true;
        target.add(this);
        target.appendJavaScript(
                "$('#" + getModalId() + "').modal('show');");
    }
    public void hide(AjaxRequestTarget target) {
        target.appendJavaScript(
                "$('#" + getModalId() + "').modal('hide');");
    }
}
