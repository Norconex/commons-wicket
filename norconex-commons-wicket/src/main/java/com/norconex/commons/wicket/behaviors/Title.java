package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for adding a "title" attribute to any component. 
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class Title extends AttributeModifier {
    private static final long serialVersionUID = -8606713881612933925L;
    public Title(String title) {
        super("title", new Model<String>(title));
    }
    public Title(IModel<String> model) {
        super("title", model);
    }
}