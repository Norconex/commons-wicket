/* Copyright 2016 Norconex Inc.
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

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;

public class BootstrapAjaxPagingNavigation extends PagingNavigation {

    private static final long serialVersionUID = -4781048878992985289L;

    public BootstrapAjaxPagingNavigation(
            String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
    }
    public BootstrapAjaxPagingNavigation(String id, IPageable pageable) {
        super(id, pageable);
    }

    @Override
    protected AbstractLink newPagingNavigationLink(
            String id, IPageable pageable, long pageIndex) {
        PagingNavigationLink<?> link = (PagingNavigationLink<?>) 
                super.newPagingNavigationLink(id, pageable, pageIndex);
        link.add(new BootstrapPagingNavigationLinkBehavior(
                pageable, link));
        return link;
    }
}
