package com.norconex.commons.wicket.markup.html.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.OddEvenListItem;
import org.apache.wicket.model.IModel;

/**
 * Alternate list item CCS class for each row.  Toggles between "even" and
 * "odd".
 * @author Pascal Essiembre
 * @param <T> The underlying model object
 */
public abstract class OddEvenListView<T> extends ListView<T> {

    private static final long serialVersionUID = -454566586046623733L;
    
    /**
     * Constructor.
     * @param id See Component
     * @param model List model to cast to Serializable
     */
    public OddEvenListView(
            String id, IModel<? extends List<? extends T>> model) {
        super(id, model);
    }
    /**
     * Constructor.
     * @param id See Component
     * @param list Collection to cast to Serializable
     */
    public OddEvenListView(String id, Collection<T> list) {
        super(id, new ArrayList<T>(list));
    }
    /**
     * Constructor.
     * @param id See Component
     * @param list List to cast to Serializable
     */
    public OddEvenListView(String id, List<T> list) {
        super(id, list);
    }
    /**
     * Constructor.
     * @param id See Component
     */
    public OddEvenListView(String id) {
        super(id);
    }
    
    @Override
    protected ListItem<T> newItem(int index, IModel<T> itemModel) {
        return new OddEvenListItem<T>(index, itemModel);
    }
}