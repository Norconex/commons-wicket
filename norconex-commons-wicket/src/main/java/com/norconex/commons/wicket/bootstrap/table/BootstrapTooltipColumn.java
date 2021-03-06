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

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.bootstrap.tooltip.BootstrapTooltip;

/**
 * Boostrap tooltip column.
 * @author Pascal Essiembre
 *
 * @param <T>
 *            The model object type
 * @param <S>
 *            the type of the sorting parameter
 */
public abstract class BootstrapTooltipColumn<T, S> 
        extends AbstractColumn<T, S> {
    private static final long serialVersionUID = -1591455322217932495L;

    private final IModel<String> tooltipModel;
    
    public BootstrapTooltipColumn(
            IModel<String> displayModel, IModel<String> tooltipModel) {
        super(displayModel);
        this.tooltipModel = tooltipModel;
    }
    public BootstrapTooltipColumn(IModel<String> displayModel, 
            IModel<String> tooltipModel, S sortProperty) {
        super(displayModel, sortProperty);
        this.tooltipModel = tooltipModel;
    }

    @Override
    public Component getHeader(String componentId) {
        Component header = super.getHeader(componentId);
        header.add(new BootstrapTooltip(tooltipModel));
        return header;
    }
}
