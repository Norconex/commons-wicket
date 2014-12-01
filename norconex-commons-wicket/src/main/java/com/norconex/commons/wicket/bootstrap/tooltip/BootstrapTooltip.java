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
package com.norconex.commons.wicket.bootstrap.tooltip;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Bootstrap tooltip.
 * @author Pascal Essiembre
 */
public class BootstrapTooltip extends Behavior {

    private static final long serialVersionUID = 2470923030957653822L;

    public enum Placement{ TOP, RIGHT, BOTTOM, LEFT, AUTO }
    
    private final IModel<String> text;
    private final Placement placement;
    private String containerId;
    
    public BootstrapTooltip(String text) {
        this(text, Placement.AUTO);
    }
    public BootstrapTooltip(String text, Placement placement) {
        this(Model.of(text), placement);
    }
    public BootstrapTooltip(IModel<String> text) {
        this(text, Placement.AUTO);
    }
    public BootstrapTooltip(IModel<String> text, Placement placement) {
        super();
        this.text = text;
        this.placement = placement;
    }

    public String getContainerId() {
        return containerId;
    }
    public BootstrapTooltip setContainerId(String containerId) {
        this.containerId = containerId;
        return this;
    }
    @Override
    public void bind(Component component) {
        if (text != null) {
            String p = null;
            if (placement == null) {
                p = Placement.AUTO.toString().toLowerCase();
            } else {
                p = placement.toString().toLowerCase();
            }
            component.add(new AttributeModifier("data-toggle", "tooltip"));
            component.add(new AttributeModifier("data-placement", p));
            component.add(new AttributeModifier("data-original-title", text));
            component.add(new AttributeModifier("title", text));
            component.setOutputMarkupId(true);
        }
    }
    
    @Override
    public void afterRender(Component component) {
        String componentId = "#" + component.getMarkupId();
        String containerId = componentId;
        if (StringUtils.isNotBlank(this.containerId)) {
            containerId = this.containerId;
        }
        if (text != null) {
            component.getResponse().write("<script>$('" + componentId
                    + "').tooltip({ container: '" + containerId
                    + "' });</script>");
        }
    }
}
