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

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

/**
 * This drop-down form component will display and allow to chose {@link Locale}
 * instances in a user-friendly way.
 * @author Pascal Essiembre
 */
public class LocaleDropDownChoice extends DropDownChoice<Locale> {

    private static final long serialVersionUID = 1L;
    public LocaleDropDownChoice(
            String id, IModel<Locale> model,  List<Locale> supportedLocales) {
        this(id, model, supportedLocales, null);
    }
    public LocaleDropDownChoice(
            String id, IModel<Locale> model,  
            List<Locale> supportedLocales, final Locale displayLocale) {
        super(id, model, new ListModel<Locale>(supportedLocales),
                new IChoiceRenderer<Locale>() {
            @Override
            public Locale getObject(String id, 
                    IModel<? extends List<? extends Locale>> locales) {
                return LocaleUtils.toLocale(id);
            }
            private static final long serialVersionUID = 7765914025904608599L;
            @Override
            public Object getDisplayValue(Locale locale) {
                Locale textLocale = displayLocale;
                if (textLocale == null) {
                    textLocale = locale;
                }
                return StringUtils.capitalize(locale.getDisplayName(locale));
            }
            @Override
            public String getIdValue(Locale locale, int index) {
                return locale.toString();
            }
        });
    }
}
