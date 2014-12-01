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
package com.norconex.commons.wicket.model;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.resource.loader.IStringResourceLoader;

//TODO test that it supports both class and package or rename accordingly.
/**
 * Gets a string resource model relative to a given class, 
 * the same way strings can be
 * obtained relative to a component.
 * 
 * @author Pascal Essiembre
 */
public class ClassResourceModel extends LoadableDetachableModel<String> {

    private static final long serialVersionUID = 1469043504243509193L;

    private Class<?> klass;
    private String key;
    private Locale locale;
    
    public ClassResourceModel(Class<?> klass, String key) {
        this(klass, key, null);
    }
    public ClassResourceModel(
            Class<?> klass, String key, Locale locale) {
        this.klass = klass;
        this.key = key;
        this.locale = locale;
    }

    @Override
    protected String load() {
        Locale theLocale = locale;
        if (theLocale == null) {
            theLocale = Session.get().getLocale();
        }
        List<IStringResourceLoader> loaders = 
                Application.get().getResourceSettings()
                        .getStringResourceLoaders();
        for (IStringResourceLoader loader : loaders) {
            String string = loader.loadStringResource(klass, key, 
                    theLocale, Session.get().getStyle(), null);
            if (StringUtils.isNotBlank(string)) {
                return string;
            }
        }
        return null;
    }

    @Override
    public void detach() {
        super.detach();
    }
}
