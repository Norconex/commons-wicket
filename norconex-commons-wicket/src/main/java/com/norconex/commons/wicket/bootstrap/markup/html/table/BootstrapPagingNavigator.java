package com.norconex.commons.wicket.bootstrap.markup.html.table;

import java.io.Serializable;

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
import org.apache.wicket.model.IModel;

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
                item.add(new AttributeModifier("class", new PageLinkCssModel(
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
        navCont.add(new AttributeModifier("class", new PageLinkCssModel(
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
                new PageLinkIncrementCssModel(pageable, pageIndex)));

        // change original wicket-link, so that it always generates href
        navCont.add(new PagingNavigationIncrementLink<Void>(
                id, pageable, increment));
        return navCont;
    }

    class PageLinkCssModel implements IModel<String>, Serializable {
        private static final long serialVersionUID = -6329531365266706790L;
        private final long pageNumber;
        protected final IPageable pageable;
        private final String css;

        public PageLinkCssModel(IPageable pageable, 
                long pageNumber, String css) {
            this.pageNumber = pageNumber;
            this.pageable = pageable;
            this.css = css;
        }

        @Override
        public String getObject() {
            return isSelected() ? css : "";
        }

        @Override
        public void setObject(String object) {
        }

        @Override
        public void detach() {
        }

        public boolean isSelected() {
            return getPageNumber() == pageable.getCurrentPage();
        }

        private long getPageNumber() {
            long idx = pageNumber;
            if (idx < 0) {
                idx = pageable.getPageCount() + idx;
            }

            if (idx > (pageable.getPageCount() - 1)) {
                idx = pageable.getPageCount() - 1;
            }

            if (idx < 0) {
                idx = 0;
            }

            return idx;
        }

    }

    public class PageLinkIncrementCssModel implements IModel<String>,
            Serializable {

        private static final long serialVersionUID = -6199337400800074608L;
        protected final IPageable pageable;
        private final long pageNumber;

        public PageLinkIncrementCssModel(IPageable pageable, long pageNumber) {
            this.pageable = pageable;
            this.pageNumber = pageNumber;
        }

        @Override
        public String getObject() {
            return isEnabled() ? "" : "disabled";
        }

        @Override
        public void setObject(String object) {
        }

        @Override
        public void detach() {
        }

        public boolean isEnabled() {
            if (pageNumber < 0) {
                return !isFirst();
            } else {
                return !isLast();
            }
        }

        public boolean isFirst() {
            return pageable.getCurrentPage() <= 0;
        }

        public boolean isLast() {
            return pageable.getCurrentPage() >= (pageable.getPageCount() - 1);
        }
    }
}