package com.norconex.commons.wicket.bootstrap.table;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;

public class BootstrapPagingNavigationLinkBehavior 
        extends Behavior {

    private static final long serialVersionUID = -4243246170121074450L;

    private final IPageable pageable;
    private final PagingNavigationLink<?> link;

    public BootstrapPagingNavigationLinkBehavior(
            final IPageable pageable, PagingNavigationLink<?> link) {
        this.pageable = pageable;
        this.link = link;
    }

    @Override
    public void beforeRender(Component component) {
        StringBuilder html = new StringBuilder();
        html.append("<li");
        if (link.getPageNumber() == pageable.getCurrentPage()) {
            html.append(" class=\"active\">");
        } else {
            html.append(">");
        }
        component.getResponse().write(html);
    }
    @Override
    public void afterRender(Component component) {
        component.getResponse().write("</li>");
    }
}
