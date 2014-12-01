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
package com.norconex.commons.wicket.markup.html.panel;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.core.util.resource.PackageResourceStream;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.resource.ResourceUtil;
import org.apache.wicket.util.resource.IResourceStream;

public class VelocityFilePanel extends Panel {

    private static final long serialVersionUID = 8901684892820127494L;

    private final IResourceStream templateStream; 
    private final Map<String, Serializable> variables = new HashMap<>();
            
    public VelocityFilePanel(String id, Class<?> scope, String fileName) {
        this(id, scope, fileName, null);
    }
    public VelocityFilePanel(String id, Class<?> scope, String fileName, 
            Map<String, Serializable> variables) {
        super(id, new MapModel<String, Object>());
        this.templateStream = new PackageResourceStream(scope, fileName);
        if (variables != null) {
            this.variables.putAll(variables);
        }
    }

    @Override
    protected void onRender() {
        VelocityContext context = createVelocityContext(variables);
        VelocityEngine engine = createVelocityEngine();
        StringWriter out = new StringWriter();
        engine.evaluate(context, out, "VelocityFilePanel", 
                ResourceUtil.readString(templateStream));
        getResponse().write(out.toString());
        try {
            templateStream.close();
        } catch (IOException e) {
            throw new WicketRuntimeException(e);
        }
    }

    protected VelocityEngine createVelocityEngine() {
        return new VelocityEngine();
    }
    protected VelocityContext createVelocityContext(
            Map<String, Serializable> variables) {
        VelocityContext context = new VelocityContext();
        for (Entry<String, Serializable> entry : variables.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }
        return context;
    }
}
