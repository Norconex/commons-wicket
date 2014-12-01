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
package com.norconex.commons.wicket;

import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IClusterable;

import com.norconex.commons.wicket.model.ClassResourceModel;
import com.norconex.commons.wicket.resource.loader.StringResourceLoaderUtil;

/**
 * Base class adding useful Wicket utility methods to non-component classes.
 * @author Pascal Essiembre
 */
public abstract class WicketClass implements IClusterable {

    private static final long serialVersionUID = 4154895530784972223L;

    public Session getSession() {
        return Session.get();
    }
    public Application getApplication() {
        return Application.get();
    }
    public String getString(String key) {
        return getString(key, Session.get().getLocale());
    }
    public String getString(String key, Locale locale) {
        return StringResourceLoaderUtil.getString(getClass(), key, locale);
    }
    public IModel<String> getStringModel(String key) {
        return new ClassResourceModel(getClass(), key);
    }
    public IModel<String> getStringModel(String key, Locale locale) {
        return new ClassResourceModel(getClass(), key, locale);
    }
    public Locale getLocale() {
        return getSession().getLocale();
    }
}
