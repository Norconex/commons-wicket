/* Copyright 2012-2016 Norconex Inc.
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
package com.norconex.commons.wicket.bootstrap.table;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationIncrementLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;

/**
 * Bootstrap Ajax Paging Navigator.
 * @author Pascal Essiembre
 */
public class BootstrapAjaxPagingNavigator extends AjaxPagingNavigator {

    private static final long serialVersionUID = 9222964180699439817L;

    private String cssClass = "pagination pagination-sm";
    
    public BootstrapAjaxPagingNavigator(
            String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
    }

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    // regular paginagion links
    @Override
    protected PagingNavigation newNavigation(String id, IPageable pageable,
            IPagingLabelProvider labelProvider) {
        return new BootstrapAjaxPagingNavigation(id, pageable, labelProvider);
    }

    // "first" and "last" links
    @Override
    protected AbstractLink newPagingNavigationLink(String id,
            IPageable pageable, int pageNumber) {
        PagingNavigationLink<?> link = (PagingNavigationLink<?>) 
                super.newPagingNavigationLink(id, pageable, pageNumber);
        link.add(new BootstrapPagingNavigationFirstLastLinkBehavior(
                pageable, link, getCssClass()));
        return link;
    }

    // "previous" and "next" links
    @Override
    protected AbstractLink newPagingNavigationIncrementLink(String id,
            IPageable pageable, int increment) {
        PagingNavigationIncrementLink<?> link = 
                (PagingNavigationIncrementLink<?>) 
                        super.newPagingNavigationIncrementLink(
                                id, pageable, increment);
        link.add(new BootstrapPagingNavigationPrevNextLinkBehavior(
                pageable, link));
        return link;
    }

    /**
     * Gets the &lt;ul&gt; CSS class.
     * @return CSS class
     */
    public String getCssClass() {
        return cssClass;
    }
    /**
     * Sets the &lt;ul&gt; CSS class.
     * @param cssClass CSS class
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
}