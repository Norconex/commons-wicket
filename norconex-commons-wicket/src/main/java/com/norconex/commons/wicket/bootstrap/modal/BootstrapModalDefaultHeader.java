package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.behaviors.CssClass;

public class BootstrapModalDefaultHeader extends Panel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    private final Label titleLabel;

    public BootstrapModalDefaultHeader(
            String id, IModel<String> title) {
        this(id, title, null);
    }

    public BootstrapModalDefaultHeader(
            String id, IModel<String> title, String fontIcon) {
        super(id);
        this.titleLabel = new Label("modalTitle", title);
        WebMarkupContainer icon = new WebMarkupContainer("icon");
        if (StringUtils.isNotBlank(fontIcon)) {
            icon.add(new CssClass(fontIcon));
        } else {
            icon.setVisible(false);
        }
        add(icon);
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
