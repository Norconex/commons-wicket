package com.norconex.commons.wicket.bootstrap.progress;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;

import com.norconex.commons.wicket.behaviors.CssClass;
import com.norconex.commons.wicket.behaviors.CssStyle;
import com.norconex.commons.wicket.markup.html.panel.CssPanel;

public class BootstrapProgressBar extends CssPanel {

    private static final long serialVersionUID = -6121842137592573264L;

    private final WebMarkupContainer progress;
    private int percent;
    private boolean labelDisabled;
    private String barCssClass;
    
    public BootstrapProgressBar(final String id) {
        this(id, 0);
    }
    public BootstrapProgressBar(
            final String id, double fraction) {
        this(id, toPercent(fraction));
    }
    public BootstrapProgressBar(
            final String id, int percent) {
        super(id);
        this.percent = percent;
        setOutputMarkupId(true);
        progress = new WebMarkupContainer("progress") {
            private static final long serialVersionUID = -1104168092685325754L;
            @Override
            protected void onBeforeRender() {
                updateComponent();
                super.onBeforeRender();
            }
        };
        add(progress);
    }

    public int getPercent() {
        return percent;
    }
    public void setPercent(int percent) {
        this.percent = percent;
    }
    public void setPercent(double fraction) {
        this.percent = toPercent(fraction);
    }
    private static int toPercent(double fraction) {
        return BigDecimal.valueOf(fraction).scaleByPowerOfTen(2).intValue();
    }
    
    public boolean isLabelDisabled() {
        return labelDisabled;
    }
    public void setLabelDisabled(boolean labelDisabled) {
        this.labelDisabled = labelDisabled;
    }

    public String getBarCssClass() {
        return barCssClass;
    }
    public void setBarCssClass(String barCssClass) {
        this.barCssClass = barCssClass;
    }

    public void update(AjaxRequestTarget target) {
        target.add(progress);
    }
    private void updateComponent() {
        WebMarkupContainer bar = new WebMarkupContainer("bar");

        
        
        bar.add(new AttributeModifier("aria-valuenow", percent));
        bar.add(new AttributeModifier("style", "width: " + percent + "%;"));
        Label label = new Label("label", percent + "%");
        if (labelDisabled) {
            label.add(new AttributeModifier("class", "sr-only"));
        } else if (percent < 20) {
            bar.add(new CssStyle("color: darkgrey;"));
        }
        if (StringUtils.isNotBlank(barCssClass)) {
            bar.add(new CssClass(barCssClass));
        }
        bar.add(label);
        progress.addOrReplace(bar);
    }

}