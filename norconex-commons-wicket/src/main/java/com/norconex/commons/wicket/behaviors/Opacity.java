package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.Model;


public class Opacity extends Behavior {

    private static final long serialVersionUID = 2584653619134082225L;

    private final float opacity;
    private final boolean mouseOverEffect;
    
    /**
     * 
     * @param opacity value from 0.0 to 1.0
     */
    public Opacity(float opacity) {
        this(opacity, false);
    }    
    public Opacity(float opacity, boolean mouseOverEffect) {
        super();
        this.opacity = opacity;
        this.mouseOverEffect = mouseOverEffect;
    }

    @SuppressWarnings("nls")
    @Override
    public void bind(Component component) {
        int intOpacity = (int) (opacity * 100.0f);
        
        component.add(new CssStyle(
                "opacity:" + opacity + "; "
              + "filter:alpha(opacity=" + intOpacity + ")"));
        if (mouseOverEffect) {
            component.add(new AttributeAppender(
                "onmouseover", new Model<String>("this.style.opacity=1; "
              + "if (this.filters) {this.filters.alpha.opacity=100;}"), "; "));
            component.add(new AttributeAppender(
                "onmouseout", new Model<String>(
                    "this.style.opacity=" + opacity 
                  + "; if (this.filters) {this.filters.alpha.opacity="
                  + intOpacity + ";}"), "; "));
        }
    }
}