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
//        return new Folder<File>(id, tree, model) {
//            private static final long serialVersionUID = 5637975745530454903L;
//
//            @Override
//            protected IModel<String> newLabelModel(IModel<File> lblModel) {
//                File file = lblModel.getObject();
//                if (isDrive(file)) {
//                    return new Model<String>(file.getAbsolutePath());
//                }
//                return new Model<String>(lblModel.getObject().getName());
//            }
//            
//            @Override
//            protected boolean isClickable() {
//                return true;
//            }
//
//            @Override
//            protected void onClick(AjaxRequestTarget target) {
//                BootstrapSelectableFolderContent.this.nodeClicked(
//                        getModelObject(), tree, target);
//            }
//
//            @Override
//            protected boolean isSelected() {
//               return BootstrapSelectableFolderContent.this.isSelected(
//                       getModelObject());
//            }
//
//            @Override
//            protected String getOtherStyleClass(File file) {
//                return "nx-commons-fsnav-file";
////                if (file.isDirectory() || isDrive(file)) {
////                    return "fa fa-folder-o";
////                }
////                return super.getOtherStyleClass(file);
//            }
//            @Override
//            protected String getClosedStyleClass() {
//                return "nx-commons-fsnav-folder-closed";
//            }
//            @Override
//            protected String getOpenStyleClass() {
//                return "nx-commons-fsnav-folder-open";
//            }
//            @Override
//            protected String getSelectedStyleClass() {
//                return "";
//            }
//
//            private boolean isDrive(File file) {
//                return file.getAbsolutePath().matches("\\w+:\\\\");
//            }
//        };
    }
}
