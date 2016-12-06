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

import java.io.Serializable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;

/**
 * Convenience class for modifying a CSS style attribute.
 * To append to any existing values of a style attribute instead, use 
 * {@link CssStyleAppender}.
 * @author Pascal Essiembre
 */
public class CssStyleModifier extends AttributeModifier {
    private static final long serialVersionUID = -2038625850286325855L;
    public CssStyleModifier(IModel<?> replaceModel) {
        super("style", replaceModel);
    }
    public CssStyleModifier(Serializable value) {
        super("style", value);
    }
}