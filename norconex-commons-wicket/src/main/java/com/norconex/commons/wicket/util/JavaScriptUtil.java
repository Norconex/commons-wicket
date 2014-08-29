package com.norconex.commons.wicket.util;

import org.apache.wicket.Component;

public final class JavaScriptUtil {

    private JavaScriptUtil() {
        super();
    }

    public static String getJQueryId(Component component) {
        return "$(\"#" + component.getMarkupId() + "\")";
    }
}
