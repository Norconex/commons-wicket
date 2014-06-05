package com.norconex.commons.wicket.markup.html.i18n;

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.cookies.CookieUtils;

public final class SessionLocaleUtils {

    public static final String COOKIE_LOCALE_KEY = "locale";
    
    private SessionLocaleUtils() {
        super();
    }

    /**
     * Sets the locale in the session and in a browser cookie.
     * @param locale session locale
     */
    public static void setSessionCookieLocale(Locale locale) {
        setSessionCookieLocale(locale, null);
    }
    /**
     * Sets the locale in the session and in a browser cookie
     * and reload the current page.
     * @param locale session locale
     * @param target Ajax target
     */
    public static void setSessionCookieLocale(
            Locale locale, AjaxRequestTarget target) {
        setSessionLocale(locale, target);
        setCookieLocale(locale);
    }
    
    /**
     * Sets the session locale.
     * @param locale session locale
     */
    public static void setSessionLocale(Locale locale) {
        setSessionLocale(locale, null);
    }
    /**
     * Sets the session locale and reload the current page.
     * @param locale session locale
     * @param target Ajax target
     */
    public static void setSessionLocale(
            Locale locale, AjaxRequestTarget target) {
        Session.get().setLocale(locale);
        if (target != null) {
            target.appendJavaScript("window.location.reload();");
        }
    }

    
    /**
     * Sets the locale to a cookie. 
     * @param locale session locale
     */
    public static void setCookieLocale(Locale locale) {
        new CookieUtils().save(COOKIE_LOCALE_KEY, locale.toString());
    }
    /**
     * Gets the locale from a cookie.  If the cookie does not have the locale
     * set, returns null.
     */
    public static Locale getCookieLocale() {
        return getCookieLocale(null);
    }
    /**
     * Gets the locale from a cookie.  If the cookie does not have the locale
     * set, returns the default locale.
     * @param defaultLoale default local when no cookie locale is set
     */
    public static Locale getCookieLocale(Locale defaultLocale) {
        String localeStr = new CookieUtils().load(COOKIE_LOCALE_KEY);
        Locale locale = null;
        if (StringUtils.isNotBlank(localeStr)) {
            locale = LocaleUtils.toLocale(localeStr);
        }
        if (locale == null) {
            locale = defaultLocale;
        }
        return locale;
    }
}
