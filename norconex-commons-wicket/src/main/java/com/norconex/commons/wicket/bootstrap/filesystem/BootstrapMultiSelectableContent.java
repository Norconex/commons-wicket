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
//        return new Folder<File>(id, tree, model) {
//            private static final long serialVersionUID = 7296733238240749590L;
//
//            @Override
//            protected IModel<String> newLabelModel(IModel<File> fileModel) {
//                File file = fileModel.getObject();
//                if (isDrive(file)) {
//                    return new Model<String>(file.getAbsolutePath());
//                }
//                return new Model<String>(fileModel.getObject().getName());
//            }
//
//            @Override
//            protected boolean isClickable() {
//                return true;
//            }
//
//            @Override
//            protected void onClick(AjaxRequestTarget target) {
//                BootstrapMultiSelectableFolderContent.this.nodeClicked(
//                        getModelObject(), tree, target);
//            }
//
//            @Override
//            protected boolean isSelected() {
//                return BootstrapMultiSelectableFolderContent.this.isSelected(
//                        getModelObject());
//            }
//
//            @Override
//            protected String getOtherStyleClass(File file) {
//                return "nx-commons-fsnav-file";
////
////                if (file.isDirectory() || isDrive(file)) {
////                    return "tree-folder-closed";
////                }
////                return super.getOtherStyleClass(file);
//            }
//            @Override
//            protected String getSelectedStyleClass() {
//                return "nx-commons-fsnavigator-selected";
//            }
//            private boolean isDrive(File file) {
//                return file.getAbsolutePath().matches("\\w+:\\\\");
//            }
//        };
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
