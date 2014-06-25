package com.norconex.commons.wicket.markup.html.i18n;

import java.util.List;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

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
public class SessionLocaleDropDownChoice extends LocaleDropDownChoice {

    private static final long serialVersionUID = -8075759492251053004L;

    public SessionLocaleDropDownChoice(
            String id, List<Locale> supportedLocales) {
        this(id, supportedLocales, null);
    }
    public SessionLocaleDropDownChoice(String id, 
            List<Locale> supportedLocales, Locale displayLocale) {
        super(id, getClosestLocale(supportedLocales),
                supportedLocales, displayLocale);
        add(new AjaxFormComponentUpdatingBehavior("onchange") {
            private static final long serialVersionUID = -1662608278242800064L;
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                Locale locale = getModelObject();
                SessionLocaleUtils.setSessionCookieLocale(locale, target);
            }
        });
    }

    private static IModel<Locale> getClosestLocale(
            List<Locale> supportedLocales) {
        if (supportedLocales == null || supportedLocales.isEmpty()) {
            throw new IllegalArgumentException(
                    "\"supportedLocales\" cannot be empty or null.");
        }
        Locale locale = SessionLocaleUtils.getCookieLocale(
                Session.get().getLocale());
        for (Locale supLocale : supportedLocales) {
            if (supLocale.getLanguage().equals(locale.getLanguage())) {
                return new Model<Locale>(supLocale);
            }
        }
        return new Model<Locale>(supportedLocales.get(0));
    }
}
