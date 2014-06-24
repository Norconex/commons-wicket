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

    public SortablePropertyComparator(S property, boolean ascending) {
        this(new SortParam<S>(property, ascending));
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((sortParam == null) ? 0 : sortParam.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SortablePropertyComparator<?, ?> other = 
                (SortablePropertyComparator<?, ?>) obj;
        if (sortParam == null) {
            if (other.sortParam != null) {
                return false;
            }
        } else if (!sortParam.equals(other.sortParam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SortablePropertyComparator [sortParam=" + sortParam + "]";
    }
}
