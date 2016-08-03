package com.norconex.commons.wicket.bootstrap.table;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationIncrementLink;

public class BootstrapPagingNavigationPrevNextLinkBehavior 
        extends Behavior {
    
    private static final long serialVersionUID = -5121654311570103152L;

    private final IPageable pageable;
    private final PagingNavigationIncrementLink<?> link;
    
    public BootstrapPagingNavigationPrevNextLinkBehavior(
            IPageable pageable, PagingNavigationIncrementLink<?> link) {
        super();
        this.pageable = pageable;
        this.link = link;
    }

    @Override
    public void beforeRender(Component component) {
        long pageNumber = link.getPageNumber();
        boolean disabled = (pageNumber == 0 && link.isFirst())
                || ((pageNumber == pageable.getPageCount() -1) 
                        && link.isLast());
        StringBuilder html = new StringBuilder();
        html.append("<li");
        if (disabled) {
            html.append(" class=\"disabled\">");
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
