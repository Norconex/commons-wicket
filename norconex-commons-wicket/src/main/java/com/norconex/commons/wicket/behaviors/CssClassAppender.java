/* Copyright 2016 Norconex Inc.
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

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for appending a CSS class to a component class attribute.
 * To replace an existing class attribute instead, use 
 * {@link CssClassModifier}.
 * @author Pascal Essiembre
 */
public class CssClassAppender extends AttributeAppender {
    private static final long serialVersionUID = 1316718302457074350L;
    public CssClassAppender(String cssClass) {
        this(new Model<String>(cssClass));
    }
    public CssClassAppender(IModel<String> model) {
        super("class", model, " ");
    }
}