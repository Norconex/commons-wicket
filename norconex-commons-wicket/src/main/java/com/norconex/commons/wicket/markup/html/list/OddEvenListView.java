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
            String id, IModel<? extends List<T>> model) {
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