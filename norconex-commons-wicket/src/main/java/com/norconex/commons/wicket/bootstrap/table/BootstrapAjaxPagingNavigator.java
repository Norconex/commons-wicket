package com.norconex.commons.wicket.bootstrap.table;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.repeater.AbstractRepeater;

public class BootstrapAjaxPagingNavigator extends AjaxPagingNavigator {

    private static final long serialVersionUID = 9222964180699439817L;
    /** The pageable component that needs to be updated. */
    private final IPageable pageable;

    /**
     * Constructor.
     * 
     * @param id
     *            See Component
     * @param pageable
     *            The pageable component the page links are referring to.
     */
    public BootstrapAjaxPagingNavigator(
            final String id, final IPageable pageable) {
        this(id, pageable, null);
    }

    /**
     * Constructor.
     * 
     * @param id
     *            See Component
     * @param pageable
     *            The pageable component the page links are referring to.
     * @param labelProvider
     *            The label provider for the link text.
     */
    public BootstrapAjaxPagingNavigator(
            final String id, final IPageable pageable,
            final IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
        this.pageable = pageable;
        setOutputMarkupId(true);
    }

    @Override
    protected PagingNavigation newNavigation(final String id,
            final IPageable pageable, 
            final IPagingLabelProvider labelProvider) {
        return new AjaxPagingNavigation(id, pageable, labelProvider) {
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
    protected AbstractLink newPagingNavigationLink(
            final String id, IPageable pageable, int pageNumber) {
        final AjaxPagingNavigationLink link = 
                new AjaxPagingNavigationLink(id, pageable, pageNumber) {
            private static final long serialVersionUID = -4537725137974552570L;
            protected long cullPageNumber(long pageNumber) {
                long idx = pageNumber;
                if (id.startsWith("first")) {
                    return 0;
                }
                if (id.startsWith("last")) {
                    return pageable.getPageCount() - 1;
                }
                if (id.startsWith("prev")) {
                    idx = pageable.getCurrentPage() -1;
                } else if (id.startsWith("next")) {
                    idx = pageable.getCurrentPage() + 1;
                }
                if (idx < 0) {
                    idx = 0;
                }
                if (idx > (pageable.getPageCount() - 1)) {
                    idx = pageable.getPageCount() - 1;
                }
                if (idx < 0) {
                    idx = 0;
                }
                return idx;
            }
        };
        AjaxLink<String> navCont = new AjaxLink<String>(id + "Cont") {
            private static final long serialVersionUID = -7566811745303329592L;
            @Override
            public void onClick(AjaxRequestTarget target) {
                link.onClick(target);
            }
        };
        navCont.add(link);
        
        // add css for enable/disable link
        long pageIndex = pageable.getCurrentPage() + pageNumber;
        navCont.add(new AttributeModifier("class", 
                new BootstrapPageLinkCssModel(
                        pageable, pageIndex, "disabled")));
        return navCont;
    }
    
    @Override
    protected AbstractLink newPagingNavigationIncrementLink(
            final String id, IPageable pageable, int increment) {
        final AjaxPagingNavigationLink link = 
                new AjaxPagingNavigationLink(id, pageable, increment) {
            private static final long serialVersionUID = 6737074324471003133L;
            protected long cullPageNumber(long pageNumber)             {
                long idx = pageNumber;
                if (id.startsWith("first")) {
                    return 0;
                }
                if (id.startsWith("last")) {
                    return pageable.getPageCount() - 1;
                }
                if (id.startsWith("prev")) {
                    idx = pageable.getCurrentPage() -1;
                } else if (id.startsWith("next")) {
                    idx = pageable.getCurrentPage() + 1;
                }
                if (idx < 0) {
                    idx = 0;
                }
                if (idx > (pageable.getPageCount() - 1)) {
                    idx = pageable.getPageCount() - 1;
                }
                if (idx < 0) {
                    idx = 0;
                }
                return idx;
            }
        };
        AjaxLink<String> navCont = new AjaxLink<String>(id + "Cont") {
            private static final long serialVersionUID = -7414576817418282720L;
            @Override
            public void onClick(AjaxRequestTarget target) {
                link.onClick(target);
            }
        };
        navCont.add(link);
        
        // add css for enable/disable link
        long pageIndex = pageable.getCurrentPage() + increment;
        navCont.add(new AttributeModifier("class", 
                new BootstrapPageLinkIncrementCssModel(pageable, pageIndex)));
        return navCont;
    }
    
    /**
     * Override this method to specify the markup container where your IPageable
     * is part of. This implementation is a default implementation that tries to
     * find a parent markup container and update that container. This is
     * necessary as ListViews can't be updated themselves.
     * 
     * @param target
     *            the request target to add the components that need to be
     *            updated in the ajax event.
     */
    protected void onAjaxEvent(AjaxRequestTarget target) {
        // update the container (parent) of the pageable, this assumes that
        // the pageable is a component, and that it is a child of a web
        // markup container.

        Component container = ((Component) pageable);
        // no need for a nullcheck as there is bound to be a non-repeater
        // somewhere higher in the hierarchy
        while (container instanceof AbstractRepeater) {
            container = container.getParent();
        }
        target.add(container);

        // in case the navigator is not contained by the container, we have
        // to add it to the response
        if (((MarkupContainer) container).contains(this, true) == false) {
            target.add(this);
        }
    }

}