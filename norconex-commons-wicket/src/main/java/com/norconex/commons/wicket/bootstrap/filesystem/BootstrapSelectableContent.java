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
package com.norconex.commons.wicket.bootstrap.filesystem;

import java.io.File;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.markup.html.filesystem.FileSystemNavigator;
import com.norconex.commons.wicket.markup.html.filesystem.IFileSystemContent;

/**
 * File system content component that allows single node selections.
 * This is the default implementation for {@link FileSystemNavigator}
 * @author Pascal Essiembre
 * @see FileSystemNavigator
 */
@SuppressWarnings("nls")
public class BootstrapSelectableContent implements IFileSystemContent {

    private static final long serialVersionUID = 302578782398184291L;
    private ITreeProvider<File> provider;
    private IModel<File> selected;

    public BootstrapSelectableContent(ITreeProvider<File> provider) {
        this.provider = provider;
    }

    @Override
    public void detach() {
        if (selected != null) {
            selected.detach();
        }
    }

    @Override
    public File[] getSelectedFiles() {
        if (selected != null) {
            return new File[] {selected.getObject()};
        }
        return new File[]{};
    }
    
    @Override
    public boolean isSelected(File file) {
        IModel<File> model = provider.model(file);
        try {
            return selected != null && selected.equals(model);
        } finally {
            model.detach();
        }
    }
    
    @Override
    public void nodeClicked(
           File file, AbstractTree<File> tree, final AjaxRequestTarget target) {
        if (selected != null) {
            tree.updateNode(selected.getObject(), target);

            selected.detach();
            selected = null;
        }
        selected = provider.model(file);
        tree.updateNode(file, target);
    }

    @Override
    public Component newContentComponent(
            String id, final AbstractTree<File> tree, IModel<File> model) {
        return new BootstrapFileSystemFolder(id, tree, model, this);
    }
}
