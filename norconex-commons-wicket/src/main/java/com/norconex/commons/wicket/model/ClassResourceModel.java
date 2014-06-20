package com.norconex.commons.wicket.model;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.resource.loader.IStringResourceLoader;

//TODO test that it supports both class and package or rename accordingly.
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
