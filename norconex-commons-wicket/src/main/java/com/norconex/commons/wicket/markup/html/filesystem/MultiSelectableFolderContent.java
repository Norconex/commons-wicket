package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.extensions.markup.html.repeater.util.ProviderSubset;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * File system content component that allows multiple node selections.
 * @author Pascal Essiembre
 * @see FileSystemNavigator
 */
@SuppressWarnings("nls")
public class MultiSelectableFolderContent extends FileSystemContent {

    private static final long serialVersionUID = -3165901195537601203L;
    private ProviderSubset<File> selected;

    public MultiSelectableFolderContent(ITreeProvider<File> provider) {
        selected = new ProviderSubset<File>(provider, false);
    }

    @Override
    public void detach() {
        selected.detach();
    }

    protected boolean isSelected(File file) {
        return selected.contains(file);
    }

    protected void toggle(
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
        return new Folder<File>(id, tree, model) {
            private static final long serialVersionUID = 7296733238240749590L;

            @Override
            protected boolean isClickable() {
                return true;
            }
            @Override
            protected void onClick(AjaxRequestTarget target) {
                MultiSelectableFolderContent.this.toggle(getModelObject(), tree, target);
            }
            @Override
            protected boolean isSelected() {
                return MultiSelectableFolderContent.this.isSelected(getModelObject());
            }
            @Override
            protected IModel<String> newLabelModel(IModel<File> fileModel) {
                File file = fileModel.getObject();
                if (isDrive(file)) {
                    return new Model<String>(file.getAbsolutePath());
                }
                return new Model<String>(fileModel.getObject().getName());
            }
            @Override
            protected String getOtherStyleClass(File file) {
                if (file.isDirectory() || isDrive(file)) {
                    return "tree-folder-closed";
                }
                return super.getOtherStyleClass(file);
            }
            @Override
            protected String getSelectedStyleClass() {
                return "nx-commons-fsnavigator-selected";
            }
            private boolean isDrive(File file) {
                return file.getAbsolutePath().matches("\\w+:\\\\");
            }
        };
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