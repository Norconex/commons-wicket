package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class BootstrapModalContent extends Panel {

    private static final long serialVersionUID = 3078941000564170354L;

    public BootstrapModalContent(String id) {
        super(id);
    }
    public BootstrapModalContent(String id, IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(createHeaderComponent("header"));
        add(createBodyComponent("body"));
        add(createFooterComponent("footer"));
    }

    protected String getCssClass() {
        return "modal fade";
    }
    
    protected abstract Component createHeaderComponent(String id);
    protected abstract Component createBodyComponent(String id);
    protected abstract Component createFooterComponent(String id);
    
}
