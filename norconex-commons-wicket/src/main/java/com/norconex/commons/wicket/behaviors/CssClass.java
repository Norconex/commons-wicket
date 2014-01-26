package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for adding a CSS class to a component.
 * It will append it if a class is already defined for the component.  
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class CssClass extends AttributeAppender {
    private static final long serialVersionUID = 3338008622183887581L;
    public CssClass(String cssClass) {
        this(new Model<String>(cssClass));
    }
    public CssClass(IModel<String> model) {
        super("class", model, " ");
    }
}