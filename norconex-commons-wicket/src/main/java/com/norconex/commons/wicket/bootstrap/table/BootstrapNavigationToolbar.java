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

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigatorLabel;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * Bootstrap Navigation Toolbar. 
 * @author Pascal Essiembre
 */
public class BootstrapNavigationToolbar extends AbstractToolbar {

    private static final long serialVersionUID = 6602575699270111954L;

    private final boolean showNavigationLabel;

    /**
     * Constructor.
     * @param table the data table
     * @param showNavigationLabel 
     *           whether to show the navigator label ("Showing 1 of ...")
     */
    public BootstrapNavigationToolbar(final DataTable<?, ?> table,
            boolean showNavigationLabel) {
        super(table);
        this.showNavigationLabel = showNavigationLabel;
        WebMarkupContainer span = new WebMarkupContainer("span");
        add(span);
        span.add(AttributeModifier.replace("colspan",
                new AbstractReadOnlyModel<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getObject() {
                return String.valueOf(table.getColumns().size()).intern();
            }
        }));
        span.add(newPagingNavigator("navigator", table));
        span.add(newNavigatorLabel("navigatorLabel", table));
    }

    protected PagingNavigator newPagingNavigator(String navigatorId,
            DataTable<?, ?> table) {
        return new BootstrapPagingNavigator(navigatorId, table);
    }

    protected WebComponent newNavigatorLabel(final String navigatorId,
            final DataTable<?, ?> table) {
        if (showNavigationLabel) {
            return new NavigatorLabel(navigatorId, table);
        }
        Label label = new Label(navigatorId);
        label.setVisible(false);
        return label;
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        setVisible(getTable().getPageCount() > 1);
    }
}