package com.norconex.commons.wicket.markup.html.image;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Image that never adds noise at the end of image URLs, even when it is
 * added to an {@link AjaxRequestTarget}.  It is a convenience class
 * that simply overrides {@link #shouldAddAntiCacheParameter()} to always
 * return <code>false</code>.
 * @author Pascal Essiembre
 */
public class CacheableImage extends Image {

    private static final long serialVersionUID = 70803065492246866L;
    public CacheableImage(String id, IModel<?> model) {
        super(id, model);
    }
    public CacheableImage(String id, IResource imageResource) {
        super(id, imageResource);
    }
    public CacheableImage(String id, ResourceReference resourceReference,
            PageParameters resourceParameters) {
        super(id, resourceReference, resourceParameters);
    }
    public CacheableImage(String id, ResourceReference resourceReference) {
        super(id, resourceReference);
    }
    public CacheableImage(String id, String string) {
        super(id, string);
    }
    public CacheableImage(String id) {
        super(id);
    }
    @Override
    protected final boolean shouldAddAntiCacheParameter() {
        return false;
    }
}
