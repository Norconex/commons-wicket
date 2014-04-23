package com.norconex.commons.wicket.bootstrap.markup.html.table;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigatorLabel;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class BootstrapNavigationToolbar extends AbstractToolbar {

    private static final long serialVersionUID = 6602575699270111954L;

    private final boolean showNavigationLabel;

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
                return String.valueOf(table.getColumns().size());
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