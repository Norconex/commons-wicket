package com.norconex.commons.wicket.bootstrap.table;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;

public class BootstrapPagingNavigationFirstLastLinkBehavior 
        extends Behavior {

    private static final long serialVersionUID = -4243246170121074450L;

    private String ulCssClass;
    private final IPageable pageable;
    private final PagingNavigationLink<?> link;

    public BootstrapPagingNavigationFirstLastLinkBehavior(
            final IPageable pageable, PagingNavigationLink<?> link) {
        this(pageable, link, "pagination pagination-sm");
    }
    public BootstrapPagingNavigationFirstLastLinkBehavior(
            final IPageable pageable, PagingNavigationLink<?> link,
            String ulCssClass) {
        this.pageable = pageable;
        this.link = link;
        this.ulCssClass = ulCssClass;
    }
    
    public void beforeRender(Component component) {
        StringBuilder html = new StringBuilder();
        if (link.isFirst()) {
            html.append("<ul");
            if (StringUtils.isNotBlank(getUlCssClass())) {
                html.append(" class=\"");
                html.append(getUlCssClass());
                html.append("\"");
            }
            html.append(">");
        }
        html.append("<li");
        if (link.getPageNumber() == pageable.getCurrentPage()) {
            html.append(" class=\"disabled\">");
        } else {
            html.append(">");
        }
        component.getResponse().write(html);
    }
    @Override
    public void afterRender(Component component) {
        component.getResponse().write("</li>");
        if (link.isLast()) {
            component.getResponse().write("</ul>");
        }
    }

    public String getUlCssClass() {
        return ulCssClass;
    }
    public void setUlCssClass(String ulCssClass) {
        this.ulCssClass = ulCssClass;
    }
}
