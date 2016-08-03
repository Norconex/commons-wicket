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
package com.norconex.commons.wicket.bootstrap.progress;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;

import com.norconex.commons.wicket.behaviors.CssClassAppender;
import com.norconex.commons.wicket.behaviors.CssStyleAppender;
import com.norconex.commons.wicket.markup.html.panel.CssPanel;

/**
 * Bootstrap progress bar.
 * @author Pascal Essiembre
 */
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
            bar.add(new CssStyleAppender("color: darkgrey;"));
        }
        if (StringUtils.isNotBlank(barCssClass)) {
            bar.add(new CssClassAppender(barCssClass));
        }
        bar.add(label);
        progress.addOrReplace(bar);
    }

}