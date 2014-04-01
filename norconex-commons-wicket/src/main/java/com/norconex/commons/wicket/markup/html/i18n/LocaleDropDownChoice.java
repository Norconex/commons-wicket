package com.norconex.commons.wicket.markup.html.i18n;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;


//TODO remove icon
//TODO no label, just a language drop down
//TODO provide display options (language, country, language + country).
//TODO allow one to set selection as cookie or not
//TODO allow to pass a series of locales as argument
//TODO MAYBE: have another component: SessionLocaleSelectionPanel
//       (and rename this one to LocaleDropDownChoic???  
//          so that a plain one exists for 
//        people wanting language selections in their forms... and the
//        session one for changing the session locale)
//TODO move under html.form package (where DropDownChoice is)???
//     (certainly not the session locale selector

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
