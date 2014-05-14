package com.norconex.commons.wicket.bootstrap.markup.html.table;

import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;

public class BootstrapAjaxDataTable<T, S> 
        extends BootstrapDataTable<T, S> {

    private static final long serialVersionUID = 7177941220003389156L;

    public BootstrapAjaxDataTable(final String id, 
            final List<? extends IColumn<T, S>> columns,
            final ISortableDataProvider<T, S> dataProvider, 
            final int rowsPerPage) {
        super(id, columns, dataProvider, rowsPerPage);
        setOutputMarkupId(true);
    }
    
    @Override
    protected void addToolbars(ISortableDataProvider<T, S> dataProvider) {
        addTopToolbar(new BootstrapAjaxNavigationToolbar(this, true));
        addTopToolbar(new AjaxFallbackHeadersToolbar<>(this, dataProvider));
        addBottomToolbar(new NoRecordsToolbar(this));
        addBottomToolbar(new BootstrapAjaxNavigationToolbar(this, false));
    }
}