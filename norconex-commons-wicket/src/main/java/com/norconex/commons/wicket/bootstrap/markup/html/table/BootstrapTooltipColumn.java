package com.norconex.commons.wicket.bootstrap.markup.html.table;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.bootstrap.behaviors.tooltip.BootstrapTooltip;


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
