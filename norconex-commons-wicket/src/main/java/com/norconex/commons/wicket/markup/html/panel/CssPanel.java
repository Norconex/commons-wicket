package com.norconex.commons.wicket.markup.html.panel;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResource;

/**
 * Panel automatically contributing to header any "*.css" files
 * with the same name as the panel, or having the name 
 * "wicket-package.css".  If no CSS is found it will look at the 
 * parent component hierarchy until one is found (if any).
 * @author Pascal Essiembre
 */
public abstract class CssPanel extends Panel {

    private static final long serialVersionUID = -5248495555892117265L;

    public CssPanel(String id, IModel<?> model) {
        super(id, model);
    }

    public CssPanel(String id) {
        super(id);
    }

    
    @SuppressWarnings("nls")
    @Override
    public void renderHead(IHeaderResponse response) {
        // Start local and go up to super classes to find a CSS that matches
        // the class name.
        Class<?> targetClass = this.getClass();
        do {
            String css = targetClass.getSimpleName() + ".css";
            boolean found = exists(targetClass, css);
            if (!found) {
                css = "wicket-package.css";
                found = exists(targetClass, css);
            }
            if (found) {
                response.render(CssHeaderItem.forReference(
                        new CssResourceReference(targetClass, css)));
                break; // really break, or add them all???
            }            
        } while ((targetClass = targetClass.getSuperclass()) != null);
    }
    
    protected final boolean exists(
            Class<?> targetClass, String packageFileName) {
        return PackageResource.exists(
                targetClass, packageFileName, 
                getLocale(), getStyle(), getVariation());
    }
    
}
