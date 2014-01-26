package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for adding a CSS style to a component.
 * It will append it if a style is already defined for the component.  
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class CssStyle extends AttributeAppender {
    private static final long serialVersionUID = 3897281898644519865L;
    public CssStyle(String cssStyle) {
        this(new Model<String>(cssStyle));
    }
    public CssStyle(IModel<String> model) {
        super("style", model, "; ");
    }
}