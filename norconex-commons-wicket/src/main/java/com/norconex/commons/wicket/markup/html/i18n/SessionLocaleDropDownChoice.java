/* Copyright 2012-2016 Norconex Inc.
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
        setOutputMarkupId(true);
    }
    public SessionLocaleDropDownChoice(String id, 
            List<Locale> supportedLocales, Locale displayLocale) {
        super(id, getClosestLocale(supportedLocales),
                supportedLocales, displayLocale);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AjaxFormComponentUpdatingBehavior("change") {
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
