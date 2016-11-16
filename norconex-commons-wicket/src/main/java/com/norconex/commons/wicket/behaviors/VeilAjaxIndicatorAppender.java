/* Copyright 2016 Norconex Inc.
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
package com.norconex.commons.wicket.behaviors;

import java.util.Objects;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.core.request.handler.IPartialPageRequestHandler;
import org.apache.wicket.extensions.ajax.markup.html.AjaxIndicatorAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.resource.ResourceReferenceRequestHandler;

/**
 * Version of {@link AjaxIndicatorAppender} which veils the component is it 
 * bounded to and shows a progress icon in the middle.
 * @author Pascal Essiembre
 * @since 2.0.0
 */
public class VeilAjaxIndicatorAppender extends Behavior {
    private static final long serialVersionUID = -3512877307837221165L;

    public static final String DEFAULT_CSS_CLASS = "wicket-ajax-indicator";
    
    private Component component;
    private String cssClass = DEFAULT_CSS_CLASS;
    
    @Override
    public void renderHead(
            final Component component, final IHeaderResponse response) {
        super.renderHead(component, response);

        IPartialPageRequestHandler target = component.getRequestCycle().find(
                IPartialPageRequestHandler.class);
        if (target != null) {
            final String javascript = 
                    "var e = Wicket.$('" + getMarkupId() + "'); "
                  + "if (e != null && typeof(e.parentNode) != 'undefined') {"
                  + "  e.parentNode.removeChild(e);"
                  + "}";
            target.prependJavaScript(javascript);
        }
    }


    @Override
    public void afterRender(final Component component) {
        super.afterRender(component);
        final Response r = component.getResponse();

        r.write("<div style=\""
                + "position:absolute;"
                + "display:none;"
                + "opacity:0.8;"
                + "text-align:center;"
                + "background-color:WhiteSmoke;"
//                + "border:1px solid DarkGray;"
//                + "zIndex:15000;"
                );
        r.write("\" class=\"");
        r.write(Objects.toString(getCssClass(), ""));
        r.write("\" ");
        r.write("id=\"");
        r.write(getMarkupId());
        r.write("\">");
        r.write("<img id=\"");
        r.write(getMarkupImgId());
        r.write("\" style=\"position:relative;\" src=\"");
        r.write(getIndicatorUrl());
        r.write("\" alt=\"\"/></div>");
        r.write("<script>");
        r.write("elementId = '#" + component.getMarkupId() + "';");
        r.write("hiderId = '#" + getMarkupId() + "';");
        r.write("hiderImgId = '#" + getMarkupImgId() + "';");
        r.write("$(hiderId).width($(elementId).outerWidth());");
        r.write("$(hiderId).height($(elementId).outerHeight());");
        r.write("$(hiderId).css('zIndex', $(elementId).css('zIndex') + 1);");
        r.write("$(hiderId).css({"
                + "top: $(elementId).position().top, "
                + "left: $(elementId).position().left});");
        r.write("$(hiderImgId).css({"
                + "top: ($(hiderId).height() / 2.0) "
                + "});");
        r.write("</script>");
    }

    protected CharSequence getIndicatorUrl() {
        IRequestHandler handler = new ResourceReferenceRequestHandler(
                AbstractDefaultAjaxBehavior.INDICATOR);
        return RequestCycle.get().urlFor(handler);
    }

    
    public VeilAjaxIndicatorAppender setCssClass(String cssClass) {
        this.cssClass = cssClass;
        return this;
    }
    public String getCssClass() {
        return cssClass;
    }

    public String getMarkupId() {
        return component.getMarkupId() + "--ajax-indicator";
    }
    public String getMarkupImgId() {
        return getMarkupId() + "-img";
    }

    @Override
    public final void bind(final Component component) {
        this.component = component;
    }
}
