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

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;

import com.norconex.commons.wicket.behaviors.CssClassAppender;

/**
 * Bootstrap {@link DataTable}.  Adds Bootstraps CSS classes to a data table
 * as well has providing Bootstrap pagination above and below the table. 
 * A small arrow icon is also added to sorted columns. 
 * 
 * @author Pascal Essiembre
 *
 * @param <T>
 *            The model object type
 * @param <S>
 *            the type of the sorting parameter
 */
public class BootstrapDataTable<T, S> extends DataTable<T, S> {

    private static final long serialVersionUID = 5211660464006380514L;

    private String cssClass = "nx-bootstrap-table table table-striped "
            + "table-hover table-condensed";
    
    /**
     * Constructor
     * 
     * @param id
     *            component id
     * @param columns
     *            list of IColumn objects
     * @param dataProvider
     *            model for data provider
     * @param rowsPerPage
     *            number of rows per page
     */    
    public BootstrapDataTable(final String id, 
            final List<? extends IColumn<T, S>> columns,
            final ISortableDataProvider<T, S> dataProvider, 
            final int rowsPerPage) {
        super(id, columns, dataProvider, rowsPerPage);
        addToolbars(dataProvider);
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new CssClassAppender(getCssClass()));
    }
    
    protected void addToolbars(ISortableDataProvider<T, S> dataProvider) {
        addTopToolbar(new BootstrapNavigationToolbar(this, true));
        addTopToolbar(new HeadersToolbar<S>(this, dataProvider));
        addBottomToolbar(new NoRecordsToolbar(this));
        addBottomToolbar(new BootstrapNavigationToolbar(this, false));
    }

    
    /**
     * Sets the table CSS class.
     * @param cssClass CSS class
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    /**
     * Gets the table CSS class.
     * @return CSS class
     */
    public String getCssClass() {
        return cssClass;
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(
                new CssResourceReference(getClass(), 
                        "BootstrapDataTable.css")));
    }
}
