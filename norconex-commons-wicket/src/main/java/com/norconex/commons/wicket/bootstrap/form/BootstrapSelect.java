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
package com.norconex.commons.wicket.bootstrap.form;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

import com.norconex.commons.wicket.behaviors.CssClassAppender;

/**
 * Change the look-and-feel of a &lt;select&gt; component to Bootstrap.
 * @author Pascal Essiembre
 */
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
        component.add(new CssClassAppender("selectpicker"));
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