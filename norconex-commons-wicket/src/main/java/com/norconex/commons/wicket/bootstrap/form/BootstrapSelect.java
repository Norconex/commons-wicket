package com.norconex.commons.wicket.bootstrap.form;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

import com.norconex.commons.wicket.behaviors.CssClass;

@SuppressWarnings("nls")
public class BootstrapSelect extends Behavior {

    private static final long serialVersionUID = 947132455990206834L;
    private final String options;
    private final String onChangeJavascript;
    
    public BootstrapSelect() {
        this(null);
    }
    //TODO have accessors for supported options instead
    public BootstrapSelect(String options) {
        this(options, null);
    }
    public BootstrapSelect(String options, String onChangeJavascript) {
        super();
        this.options = StringUtils.trimToEmpty(options);
        this.onChangeJavascript = onChangeJavascript;
    }

    @Override
    public void bind(Component component) {
        component.add(new CssClass("selectpicker"));
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        if (!"select".equalsIgnoreCase(tag.getName())) {
            throw new WicketRuntimeException(
                    "BootstrapSelect can only be applied to <select> tags.");
        }
        super.onComponentTag(component, tag);
    }
    
    @Override
    public void afterRender(Component component) {
        String js = "<script>$('#"
                + component.getMarkupId() + "').selectpicker("
                + options + ");";
        if (StringUtils.isNotBlank(onChangeJavascript)) {
            js += "$('#" + component.getMarkupId() + "').change(function() {"
                    + onChangeJavascript + "});";
        }
        js += "</script>";
        component.getResponse().write(js);
    }
}