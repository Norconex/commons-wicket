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

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.core.util.resource.PackageResourceStream;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.resource.ResourceUtil;
import org.apache.wicket.util.resource.IResourceStream;

public class FilePanel extends Panel {

    private static final long serialVersionUID = -7866404245138616157L;

    private final IResourceStream fileStream; 
    
    public FilePanel(String id, Class<?> scope, String fileName) {
        super(id, new MapModel<String, Object>());
        this.fileStream = new PackageResourceStream(scope, fileName);
    }

    @Override
    protected void onRender() {
        getResponse().write(ResourceUtil.readString(fileStream));
        try {
            fileStream.close();
        } catch (IOException e) {
            throw new WicketRuntimeException(e);
        }
    }
    
}
