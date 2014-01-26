package com.norconex.commons.wicket;

import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IClusterable;

import com.norconex.commons.wicket.model.ClassStringResourceModel;
import com.norconex.commons.wicket.resource.loader.StringResourceLoaderUtil;

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
        return new ClassStringResourceModel(getClass(), key);
    }
    public IModel<String> getStringModel(String key, Locale locale) {
        return new ClassStringResourceModel(getClass(), key, locale);
    }
}
