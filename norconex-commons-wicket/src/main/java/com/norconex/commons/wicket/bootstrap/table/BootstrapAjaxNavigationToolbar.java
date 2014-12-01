/* Copyright 2012-2014 Norconex Inc.
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

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * Bootstrap Ajax Navigation Toolbar.
 * @author Pascal Essiembre
 */
public class BootstrapAjaxNavigationToolbar extends BootstrapNavigationToolbar {

    private static final long serialVersionUID = -1135733334323651636L;

    public BootstrapAjaxNavigationToolbar(
            final DataTable<?, ?> table, boolean showNavigationLabel) {
        super(table, showNavigationLabel);
    }

    @Override
    protected PagingNavigator newPagingNavigator(
            final String navigatorId, final DataTable<?, ?> table) {
        return new BootstrapAjaxPagingNavigator(navigatorId, table) {
            private static final long serialVersionUID = 1637947456396615468L;
            @Override
            protected void onAjaxEvent(final AjaxRequestTarget target) {
                target.add(table);
            }
        };
    }
}
