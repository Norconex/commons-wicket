package com.norconex.commons.wicket.bootstrap.table;

import java.io.Serializable;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;

public class BootstrapPageLinkIncrementCssModel 
        implements IModel<String>, Serializable {

    private static final long serialVersionUID = -6199337400800074608L;
    protected final IPageable pageable;
    private final long pageNumber;

    public BootstrapPageLinkIncrementCssModel(
            IPageable pageable, long pageNumber) {
        this.pageable = pageable;
        this.pageNumber = pageNumber;
    }

    @Override
    public String getObject() {
        return isEnabled() ? "" : "disabled";
    }

    @Override
    public void setObject(String object) {
    }

    @Override
    public void detach() {
    }

    public boolean isEnabled() {
        if (pageNumber < 0) {
            return !isFirst();
        } else {
            return !isLast();
        }
    }

    public boolean isFirst() {
        return pageable.getCurrentPage() <= 0;
    }

    public boolean isLast() {
        return pageable.getCurrentPage() >= (pageable.getPageCount() - 1);
    }
}