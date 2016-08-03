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

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

/**
 * Convenience behavior that writes the provided string before and after a 
 * component is rendered.
 * @author Pascal Essiembre
 * @see WriteBefore
 * @see WriteAfter
 * @since 2.0.0
 */
public class WriteAround extends Behavior {

    private static final long serialVersionUID = 3144698866624152771L;

    private final CharSequence beforeSequence;
    private final CharSequence afterSequence;
    
    /**
     * Constructor.
     * @param beforeSequence the content to write before component is rendered
     * @param afterSequence the content to write after component is rendered
     */
    public WriteAround(
            CharSequence beforeSequence, CharSequence afterSequence) {
        this.beforeSequence = beforeSequence;
        this.afterSequence = afterSequence;
    }
    @Override
    public void beforeRender(Component component) {
        component.getResponse().write(beforeSequence);
    }
    @Override
    public void afterRender(Component component) {
        component.getResponse().write(afterSequence);
    }
}
