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
package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.Model;

/**
 * Add an opacity to a wicket component with an optional mouseover effect.
 * The mouseover effect removes the opacity layer on the component when
 * the mouse is over it.
 * @author Pascal Essiembre
 */
public class Opacity extends Behavior {

    private static final long serialVersionUID = 2584653619134082225L;

    private final float opacity;
    private final boolean mouseOverEffect;
    
    /**
     * 
     * @param opacity value from 0.0 to 1.0
     */
    public Opacity(float opacity) {
        this(opacity, false);
    }    
    public Opacity(float opacity, boolean mouseOverEffect) {
        super();
        this.opacity = opacity;
        this.mouseOverEffect = mouseOverEffect;
    }

    @SuppressWarnings("nls")
    @Override
    public void bind(Component component) {
        int intOpacity = (int) (opacity * 100.0f);
        
        component.add(new CssStyleAppender(
                "opacity:" + opacity + "; "
              + "filter:alpha(opacity=" + intOpacity + ")"));
        if (mouseOverEffect) {
            component.add(new AttributeAppender(
                "onmouseover", new Model<String>("this.style.opacity=1; "
              + "if (this.filters) {this.filters.alpha.opacity=100;}"), "; "));
            component.add(new AttributeAppender(
                "onmouseout", new Model<String>(
                    "this.style.opacity=" + opacity 
                  + "; if (this.filters) {this.filters.alpha.opacity="
                  + intOpacity + ";}"), "; "));
        }
    }
}