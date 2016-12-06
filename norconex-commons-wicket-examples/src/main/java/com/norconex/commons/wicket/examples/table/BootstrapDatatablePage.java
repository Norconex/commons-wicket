package com.norconex.commons.wicket.examples.table;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.norconex.commons.wicket.bootstrap.table.BootstrapDataTable;
import com.norconex.commons.wicket.examples.BaseExamplePage;

public class BootstrapDatatablePage extends BaseExamplePage {
	private static final long serialVersionUID = 1L;

	public BootstrapDatatablePage(final PageParameters parameters) {
		super(parameters);

        List<IColumn<Contact, String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<Contact, String>(
                new Model<>("First Name"), "firstName", "firstName"));
        columns.add(new PropertyColumn<Contact, String>(
                new Model<>("Last Name"), "lastName", "lastName"));

        SortableContactDataProvider dataProvider = 
                new SortableContactDataProvider();
        DataTable<Contact, String> dataTable = 
                new BootstrapDataTable<>("table", columns, dataProvider, 5);
        add(dataTable);
    }
}


