package com.norconex.commons.wicket.markup.html.i18n;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.cookies.CookieUtils;

/**
 * This locale selection drop-down will set the user session locale
 * and also store the locale as a cookie that can be queried at session-creation
 * time.  Upon selecting a new locale, the screen will be refreshed, to 
 * force reloading in the new locale. The cookie name is "locale".
 * This drop-down is not meant to be used as a form component, use 
 * {@link LocaleDropDownChoice} for that instead.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class SessionLocaleSelectionPanel extends LocaleDropDownChoice {

    private static final long serialVersionUID = -8075759492251053004L;
    public static final String COOKIE_LOCALE_KEY = "locale";
    

    public SessionLocaleSelectionPanel(
            String id, List<Locale> supportedLocales) {
        this(id, supportedLocales, null);
    }
    public SessionLocaleSelectionPanel(String id, 
            List<Locale> supportedLocales, Locale displayLocale) {
        super(id, getClosestLocale(supportedLocales),
                supportedLocales, displayLocale);
        add(new AjaxFormComponentUpdatingBehavior("onchange") {
            private static final long serialVersionUID = -1662608278242800064L;
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                Locale locale = getModelObject();
                getSession().setLocale(locale);
                target.appendJavaScript("window.location.reload();");
                new CookieUtils().save(COOKIE_LOCALE_KEY, locale.toString());
            }
        });
    
    }

    private static IModel<Locale> getClosestLocale(
            List<Locale> supportedLocales) {
        if (supportedLocales == null || supportedLocales.isEmpty()) {
            throw new IllegalArgumentException(
                    "\"supportedLocales\" cannot be empty or null.");
        }
        Locale locale = null;
        String localeStr = new CookieUtils().load(COOKIE_LOCALE_KEY);
        if (StringUtils.isNotBlank(localeStr)) {
            locale = LocaleUtils.toLocale(localeStr);
        } else {
            locale = Session.get().getLocale();
        }
        for (Locale supLocale : supportedLocales) {
            if (supLocale.getLanguage().equals(locale.getLanguage())) {
                return new Model<Locale>(supLocale);
            }
        }
        return new Model<Locale>(supportedLocales.get(0));
    }
}