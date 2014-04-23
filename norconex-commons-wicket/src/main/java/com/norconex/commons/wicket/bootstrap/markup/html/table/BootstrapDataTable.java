package com.norconex.commons.wicket.bootstrap.markup.html.table;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.model.IModel;

public class BootstrapDataTable<T, S> extends DataTable<T, S> {

    private static final long serialVersionUID = 5211660464006380514L;

    public BootstrapDataTable(final String id, 
            final List<? extends IColumn<T, S>> columns,
            final ISortableDataProvider<T, S> dataProvider, 
            final int rowsPerPage) {
            super(id, columns, dataProvider, rowsPerPage);

        addTopToolbar(new BootstrapNavigationToolbar(this, true));
        addTopToolbar(new HeadersToolbar<S>(this, dataProvider));
        addBottomToolbar(new NoRecordsToolbar(this));
        addBottomToolbar(new BootstrapNavigationToolbar(this, false));
    }

    @Override
    protected Item<T> newRowItem(
            final String id, final int index, final IModel<T> model) {
        return new OddEvenItem<T>(id, index, model);
    }


}