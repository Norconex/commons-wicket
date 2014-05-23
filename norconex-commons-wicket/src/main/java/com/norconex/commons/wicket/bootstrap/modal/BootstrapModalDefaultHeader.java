package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class BootstrapModalDefaultHeader extends Panel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    private final Label titleLabel;
    
    public BootstrapModalDefaultHeader(String id, IModel<String> title) {
        super(id);
        this.titleLabel = new Label("modalTitle", title);
    }

    public Label getTitleLabel() {
        return titleLabel;
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        add(titleLabel);
    }
}
