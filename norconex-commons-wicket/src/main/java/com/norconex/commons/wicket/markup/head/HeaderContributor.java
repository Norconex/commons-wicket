package com.norconex.commons.wicket.markup.head;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

public final class HeaderContributor {

    private final IHeaderResponse response;
    
    public HeaderContributor(IHeaderResponse response) {
        super();
        this.response = response;
    }

    public HeaderContributor addJavascript(Class<?> scope, String... jsFiles) {
        addJavascript(response, scope, jsFiles);
        return this;
    }
    public HeaderContributor addCss(Class<?> scope, String... cssFiles) {
        addCss(response, scope, cssFiles);
        return this;
    }

    public static void addJavascript(
            IHeaderResponse response, Class<?> scope, String... jsFiles) {
        addJavascript(response, scope, false, jsFiles);
    }
    public static void addJavascript(
            IHeaderResponse response, Class<?> scope, 
            boolean priority, String... jsFiles) {
        for (String js : jsFiles) {
            HeaderItem item = JavaScriptHeaderItem.forReference(
                    new PackageResourceReference(scope, js));
            if (priority) {
                item = new PriorityHeaderItem(item);
            }
            response.render(item);
        }
    }
    public static void addCss(
            IHeaderResponse response, Class<?> scope, String... cssFiles) {
        addCss(response, scope, false, cssFiles);
    }

    public static void addCss(
            IHeaderResponse response, Class<?> scope, 
            boolean priority, String... cssFiles) {
        for (String css : cssFiles) {
            HeaderItem item = CssHeaderItem.forReference(
                    new PackageResourceReference(scope, css));
            if (priority) {
                item = new PriorityHeaderItem(item);
            }
            response.render(item);
        }
    }
}
