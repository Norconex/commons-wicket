package com.norconex.commons.wicket.bootstrap.filesystem;

import java.io.File;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.norconex.commons.wicket.markup.html.filesystem.IFileSystemContent;

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
