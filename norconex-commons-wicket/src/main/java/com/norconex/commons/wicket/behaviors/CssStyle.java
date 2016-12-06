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

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for adding a CSS style to a component style attribute.
 * It will append it if a style is already defined for the component.  
 * To replace an existing style attribute instead, use 
 * {@link AttributeModifier}.
 * @author Pascal Essiembre
 * @deprecated Since 2.0.0, use {@link CssStyleAppender}
 */
@Deprecated
public class CssStyle extends AttributeAppender {
    private static final long serialVersionUID = 3897281898644519865L;
    public CssStyle(String cssStyle) {
        this(new Model<String>(cssStyle));
    }
    public CssStyle(IModel<String> model) {
        super("style", model, "; ");
    }
}