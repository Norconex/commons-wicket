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
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Convenience class for adding a "title" attribute to any component. 
 * If a title attribute already exists, it will be replaced.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class Title extends AttributeModifier {
    private static final long serialVersionUID = -8606713881612933925L;
    public Title(String title) {
        super("title", new Model<String>(title));
    }
    public Title(IModel<String> model) {
        super("title", model);
    }
}