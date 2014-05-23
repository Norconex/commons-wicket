package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.behaviors.CssClass;

public abstract class BootstrapModal extends Panel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    private final IModel<String> title;
    
    public BootstrapModal(String id, IModel<String> title, IModel<?> model) {
        super(id, model);
        this.title = title;
    }
    public BootstrapModal(String id, IModel<String> title) {
        super(id);
        this.title = title;
    }

    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        Label titleLabel = new Label("modalTitle", title);

        add(new AttributeModifier("tabindex", "-1"));
        add(new AttributeModifier("role", "dialog"));
        add(new AttributeModifier("aria-hidden", "true"));
        add(new AttributeModifier("aria-labelledby", titleLabel.getMarkupId()));
        add(new CssClass(getCssClass()));
        
        add(titleLabel);
        add(createBodyComponent("body"));
        
        Fragment footerFragment = null;
        Component customFooter = createFooterComponent("customFooter");
        if (customFooter != null) {
            footerFragment = new Fragment(
                    "footerFragment", "providedFooter", this);
            footerFragment.add(customFooter);
        } else {
            footerFragment = new Fragment(
                    "footerFragment", "defaultFooter", this);
        }
        add(footerFragment);
    }

    protected String getCssClass() {
        return "modal fade";
    }
    
    protected abstract Component createBodyComponent(String id);
    protected Component createFooterComponent(String id) {
        return null;
    }
    
//    <div class="modal fade" wicket:id="modal" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
//    <div class="modal-dialog">
//      <div class="modal-content">
//        <div class="modal-header">
//          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
//          <h4 class="modal-title" id="modalTitle">Modal title</h4>
//        </div>
//        <div class="modal-body">
//          <div wicket:id="body">Body</div>
//        </div>
//        <div class="modal-footer">
//          <div wicket:id="footer">Footer</div>
//          <!-- 
//          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
//          <button type="button" class="btn btn-primary">Save changes</button>
//           -->
//        </div>
//      </div>
//    </div>
//  </div>
}
