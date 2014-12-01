/* Copyright 2012-2014 Norconex Inc.
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

import java.io.Serializable;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;

/**
 * Bootstrap PageLink Css Model.
 * @author Pascal Essiembre
 */
public class BootstrapPageLinkCssModel implements IModel<String>, Serializable {
    private static final long serialVersionUID = -6329531365266706790L;
    private final long pageNumber;
    protected final IPageable pageable;
    private final String css;

    public BootstrapPageLinkCssModel(IPageable pageable, 
            long pageNumber, String css) {
        this.pageNumber = pageNumber;
        this.pageable = pageable;
        this.css = css;
    }

    @Override
    public String getObject() {
        return isSelected() ? css : "";
    }

    @Override
    public void setObject(String object) {
    }

    @Override
    public void detach() {
    }

    public boolean isSelected() {
        return getPageNumber() == pageable.getCurrentPage();
    }

    private long getPageNumber() {
        long idx = pageNumber;
        if (idx < 0) {
            idx = pageable.getPageCount() + idx;
        }

        if (idx > (pageable.getPageCount() - 1)) {
            idx = pageable.getPageCount() - 1;
        }

        if (idx < 0) {
            idx = 0;
        }

        return idx;
    }

}