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

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.norconex.commons.wicket.markup.html.filesystem.IFileSystemContent;

/**
 * A Bootstrap file system folder representation.
 * @author Pascal Essiembre
 */
public class BootstrapFileSystemFolder extends Folder<File> {

    private final IFileSystemContent content;
    private final AbstractTree<File> tree;
    
    public BootstrapFileSystemFolder(String id, AbstractTree<File> tree,
            IModel<File> model, IFileSystemContent content) {
        super(id, tree, model);
        this.tree = tree;
        this.content = content;
    }

    private static final long serialVersionUID = 7296733238240749590L;

    @Override
    protected IModel<String> newLabelModel(IModel<File> fileModel) {
        File file = fileModel.getObject();
        if (isDrive(file)) {
            return new Model<String>(file.getAbsolutePath());
        }
        return new Model<String>(fileModel.getObject().getName());
    }

    @Override
    protected boolean isClickable() {
        return true;
    }

    @Override
    protected void onClick(AjaxRequestTarget target) {
        content.nodeClicked(getModelObject() , tree, target);
    }

    @Override
    protected boolean isSelected() {
        return content.isSelected(getModelObject());
    }

    @Override
    protected String getOtherStyleClass(File file) {
        if (file.isDirectory() || isDrive(file)) {
            return "nx-commons-fsnav-folder-closed";
        }
        return "nx-commons-fsnav-file";
    }
    @Override
    protected String getClosedStyleClass() {
        return "nx-commons-fsnav-folder-closed";
    }
    @Override
    protected String getOpenStyleClass() {
        return "nx-commons-fsnav-folder-open";
    }
    @Override
    protected String getSelectedStyleClass() {
        return "";
    }

    private boolean isDrive(File file) {
        return file.getAbsolutePath().matches("\\w+:\\\\");
    }
    
}
