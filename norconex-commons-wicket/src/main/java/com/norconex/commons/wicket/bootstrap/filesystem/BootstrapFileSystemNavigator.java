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
import java.util.Set;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.tree.NestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.Node;
import org.apache.wicket.model.IModel;

import com.norconex.commons.wicket.markup.html.filesystem.FileSystemNavigator;
import com.norconex.commons.wicket.markup.html.filesystem.FileSystemTreeProvider;
import com.norconex.commons.wicket.markup.html.filesystem.IFileSystemContent;
import com.norconex.commons.wicket.markup.html.filesystem.MultiSelectableContent;

/**
 * A component that allows browsing the server file system. 
 * The default constructor
 * will start the navigator in the application user home directory and will
 * allow only one folder/file selection.  To change the starting directory,
 * you can supply your own instance of a {@link FileSystemTreeProvider}.
 * To allow for multiple selections, call the 
 * {@link #setFileSystemContent(IFileSystemContent)} method with an instance
 * of {@link MultiSelectableContent}.
 * @see BootstrapFileSystemDialog
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class BootstrapFileSystemNavigator extends FileSystemNavigator {

    private static final long serialVersionUID = 6169629915204125307L;

    public BootstrapFileSystemNavigator(String id) {
        this(id, null);
    }
    
    public BootstrapFileSystemNavigator(String id,
            IModel<FileSystemTreeProvider> model) {
        super(id, model);
        setFileSystemContent(
                new BootstrapSelectableContent(getTreeProvider()));
    }

    @Override
    protected NestedTree<File> createTree(IModel<Set<File>> model) {
        NestedTree<File> tree = new NestedTree<File>(
                "navigator", getTreeProvider(), model) {
            private static final long serialVersionUID = 5956481756652879368L;

            @Override
            protected Component newContentComponent(
                    String id, IModel<File> node) {
                return getFileSystemContent().newContentComponent(
                        id, this, node);
            }
            
            @Override
            protected void onInitialize() {
                super.onInitialize();
            }
            
            @Override
            public Component newNodeComponent(
                    String id, final IModel<File> model) {
                Component node = new Node<File>(id, this, model) {
                    private static final long serialVersionUID = 
                            -521776832456858818L;
                    @Override
                    protected Component createContent(
                            String id, IModel<File> model) {
                        return newContentComponent(id, model);
                    }
                    @Override
                    protected String getCollapsedStyleClass() {
                        return "nx-commons-fsnav-node-collapsed";
                    }
                    @Override
                    protected String getExpandedStyleClass(File t) {
                        return "nx-commons-fsnav-node-expanded";
                    }
                    @Override
                    protected String getOtherStyleClass() {
                        return super.getOtherStyleClass();
                    }
                    @Override
                    protected void onBeforeRender() {
                        if (getFileSystemContent().isSelected(
                                model.getObject())) {
                            add(new AttributeModifier(
                                    "class", "tree-node active"));
                        } else {
                            add(new AttributeModifier(
                                    "class", "tree-node"));
                        }
                        super.onBeforeRender();
                    }
                };
                node.setOutputMarkupId(true);
                return node;
            }
        };
        return tree;
    }
}
