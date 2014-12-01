/* Copyright 2012-2014 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
