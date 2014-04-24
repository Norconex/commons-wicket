package com.norconex.commons.wicket.bootstrap.markup.html.table;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

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
