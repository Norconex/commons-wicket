package com.norconex.commons.wicket.markup.head;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.PriorityHeaderItem;

public final class JQueryLibrariesContributor {

    private JQueryLibrariesContributor() {
        super();
    }

    public static void contribute(
            Application application, IHeaderResponse response) {
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                .getJQueryReference())));  
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                 .getWicketAjaxReference())));  
        response.render(new PriorityHeaderItem(
                JavaScriptHeaderItem.forReference(
                        application.getJavaScriptLibrarySettings()
                                .getWicketEventReference())));
    }
}
