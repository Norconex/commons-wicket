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
package com.norconex.commons.wicket.resource.loader;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.resource.loader.IStringResourceLoader;
import org.apache.wicket.resource.loader.PackageStringResourceLoader;

//TODO rename to ResourceLoaderUtil if we do more than string??
/**
 * Gets a string relative to a given class
 * @author Pascal Essiembre
 */
public final class StringResourceLoaderUtil {

    
    private StringResourceLoaderUtil() {
        super();
    }

    /**
     * Relies on the {@link PackageStringResourceLoader} class to get
     * a string {@link IModel}.
     * @param klass the class used derive the package
     * @param key the string key
     * @return the proper string
     */
    public static IModel<String> getStringModel(
            final Class<?> klass, final String key) {
        return getStringModel(klass, key, Session.get().getLocale());
    }
    /**
     * Relies on the {@link PackageStringResourceLoader} class to get
     * a string {@link IModel}.
     * @param klass the class used derive the package
     * @param key the string key
     * @param locale locale to use to return string
     * @return the proper string
     */
    public static IModel<String> getStringModel(
            final Class<?> klass, final String key, final Locale locale) {
        String string = getString(klass, key, locale);
        return new Model<String>(string);
    }

    /**
     * Relies on the {@link PackageStringResourceLoader} class to get
     * a string.
     * @param klass the class used derive the package
     * @param key the string key
     * @return the proper string
     */
    public static String getString(final Class<?> klass, final String key) {
        return getString(klass, key, Session.get().getLocale());
    }
    /**
     * Relies on the {@link PackageStringResourceLoader} class to get
     * a string.
     * @param klass the class used derive the package
     * @param key the string key
     * @param locale locale to use to return string
     * @return the proper string
     */
    public static String getString(
            final Class<?> klass, final String key, final Locale locale) {
        List<IStringResourceLoader> loaders = 
             Application.get().getResourceSettings().getStringResourceLoaders();
        for (IStringResourceLoader loader : loaders) {
            String string = loader.loadStringResource(klass, key, locale, 
                    Session.get().getStyle(), null);
            if (StringUtils.isNotBlank(string)) {
                return string;
            }
        }
        return null;
    }

    
}
