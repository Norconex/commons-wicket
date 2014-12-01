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
 * Bootstrap PageLink increment CSS Model.
 * @author Pascal Essiembre
 */
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