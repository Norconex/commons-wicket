package com.norconex.commons.wicket.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.model.PropertyModel;

public class SortablePropertyComparator<T, S>
        implements Comparator<T>, Serializable {
    private static final long serialVersionUID = -9154386928818508608L;

    private final SortParam<S> sortParam;
    
    public SortablePropertyComparator(SortParam<S> sortParam) {
        super();
        this.sortParam = sortParam;
    }

    public int compare(final T o1, final T o2) {
        PropertyModel<Comparable<T>> model1 = new PropertyModel<Comparable<T>>(
                o1, Objects.toString(sortParam.getProperty(), null));
        PropertyModel<Comparable<T>> model2 = new PropertyModel<Comparable<T>>(
                o2, Objects.toString(sortParam.getProperty(), null));

        int result = new CompareToBuilder().append(
                model1.getObject(), model2.getObject()).toComparison();
        if (!sortParam.isAscending()) {
            result = -result;
        }
        return result;
    }
}
