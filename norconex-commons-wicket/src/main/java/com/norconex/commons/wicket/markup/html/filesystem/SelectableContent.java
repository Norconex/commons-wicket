package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * File system content component that allows single node selections.
 * This is the default implementation for {@link FileSystemNavigator}
 * @author Pascal Essiembre
 * @see FileSystemNavigator
 */
@SuppressWarnings("nls")
public class SelectableContent implements IFileSystemContent {

    private static final long serialVersionUID = 302578782398184291L;
    private ITreeProvider<File> provider;
    private IModel<File> selected;

    public SelectableContent(ITreeProvider<File> provider) {
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
        return new Folder<File>(id, tree, model) {
            private static final long serialVersionUID = 5637975745530454903L;

            @Override
            protected IModel<String> newLabelModel(IModel<File> lblModel) {
                File file = lblModel.getObject();
                if (isDrive(file)) {
                    return new Model<String>(file.getAbsolutePath());
                }
                return new Model<String>(lblModel.getObject().getName());
            }
            
            @Override
            protected boolean isClickable() {
                return true;
            }

            @Override
            protected String getOtherStyleClass(File file) {
                if (file.isDirectory() || isDrive(file)) {
                    return "tree-folder-closed";
                }
                return super.getOtherStyleClass(file);
            }
            
            @Override
            protected void onClick(AjaxRequestTarget target) {
                SelectableContent.this.nodeClicked(
                        getModelObject(), tree, target);
            }

            @Override
            protected String getSelectedStyleClass() {
                return "nx-commons-fsnavigator-selected";
            }
            
            @Override
            protected boolean isSelected() {
               return SelectableContent.this.isSelected(getModelObject());
            }
            private boolean isDrive(File file) {
                return file.getAbsolutePath().matches("\\w+:\\\\");
            }
        };
    }
}
