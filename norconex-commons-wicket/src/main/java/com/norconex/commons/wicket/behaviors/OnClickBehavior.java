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

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * Add an "onclick" javascript event listener on a wicket componente.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public abstract class OnClickBehavior extends AjaxEventBehavior {

    private static final long serialVersionUID = 4753399421269066084L;

    public OnClickBehavior() {
        super("onclick");
    }

    @Override
    protected final void onEvent(AjaxRequestTarget target) {
        onClick(target);
    }

    protected abstract void onClick(AjaxRequestTarget target);
    
}