package com.norconex.commons.wicket.bootstrap.markup.html.table;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationIncrementLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

public class BootstrapPagingNavigator extends PagingNavigator {

    private static final long serialVersionUID = -1453846937064545288L;

    public BootstrapPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    public BootstrapPagingNavigator(String id, IPageable pageable,
            IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
    }

    @Override
    protected PagingNavigation newNavigation(String id, IPageable pageable,
            IPagingLabelProvider labelProvider) {
        return new PagingNavigation(id, pageable, labelProvider) {
            private static final long serialVersionUID = -1041791124600426054L;

            @Override
            protected LoopItem newItem(int iteration) {
                LoopItem item = super.newItem(iteration);

                // add css for enable/disable link
                long pageIndex = getStartIndex() + iteration;
                item.add(new AttributeModifier("class", 
                        new BootstrapPageLinkCssModel(
                                pageable, pageIndex, "active")));

                return item;
            }
        };
    }

    @Override
    protected AbstractLink newPagingNavigationLink(String id,
            IPageable pageable, int pageNumber) {
        ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

        // add css for enable/disable link
        long pageIndex = pageable.getCurrentPage() + pageNumber;
        navCont.add(new AttributeModifier("class", 
                new BootstrapPageLinkCssModel(
                        pageable, pageIndex, "disabled")));

        // change original wicket-link, so that it always generates href
        navCont.add(new PagingNavigationLink<Void>(id, pageable, pageNumber));
        return navCont;
    }

    @Override
    protected AbstractLink newPagingNavigationIncrementLink(String id,
            IPageable pageable, int increment) {
        ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

        // add css for enable/disable link
        long pageIndex = pageable.getCurrentPage() + increment;
        navCont.add(new AttributeModifier("class",
                new BootstrapPageLinkIncrementCssModel(pageable, pageIndex)));

        // change original wicket-link, so that it always generates href
        navCont.add(new PagingNavigationIncrementLink<Void>(
                id, pageable, increment));
        return navCont;
    }
}