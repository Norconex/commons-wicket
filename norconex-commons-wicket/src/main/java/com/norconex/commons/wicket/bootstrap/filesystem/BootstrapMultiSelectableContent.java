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
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.extensions.markup.html.repeater.util.ProviderSubset;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.markup.html.filesystem.FileSystemNavigator;
import com.norconex.commons.wicket.markup.html.filesystem.IFileSystemContent;

/**
 * File system content component that allows multiple node selections.
 * @author Pascal Essiembre
 * @see FileSystemNavigator
 */
@SuppressWarnings("nls")
public class BootstrapMultiSelectableContent implements IFileSystemContent {

    private static final long serialVersionUID = -3165901195537601203L;
    private ProviderSubset<File> selected;

    public BootstrapMultiSelectableContent(ITreeProvider<File> provider) {
        selected = new ProviderSubset<File>(provider, false);
    }

    @Override
    public void detach() {
        selected.detach();
    }

    @Override
    public boolean isSelected(File file) {
        return selected.contains(file);
    }

    @Override
    public void nodeClicked(
           File file, AbstractTree<File> tree, final AjaxRequestTarget target) {
        if (isSelected(file)) {
            selected.remove(file);
        } else {
            selected.add(file);
        }
        tree.updateNode(file, target);
    }

    @Override
    public Component newContentComponent(
            String id, final AbstractTree<File> tree, IModel<File> model) {
        return new BootstrapFileSystemFolder(id, tree, model, this);
    }

    @Override
    public File[] getSelectedFiles() {
        List<File> files = new ArrayList<File>();
        for (File file : selected) {
            files.add(file);
        }
        return files.toArray(new File[]{});
    }
}
