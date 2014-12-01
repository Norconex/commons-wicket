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
package com.norconex.commons.wicket.bootstrap.modal;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * Default Bootstrap modal footer.
 * @author Pascal Essiembre
 */
public class BootstrapModalDefaultFooter extends Panel {

    private static final long serialVersionUID = -8150141940905259147L;
    
    public BootstrapModalDefaultFooter(String id) {
        super(id);
        setOutputMarkupId(true);
    }
}
