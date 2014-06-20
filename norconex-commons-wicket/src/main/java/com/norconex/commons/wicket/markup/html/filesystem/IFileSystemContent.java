package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.model.IDetachable;
import org.apache.wicket.model.IModel;

/**
 * Base class for file system node components, influencing how nodes 
 * will be rendered and behave.
 * @author Pascal Essiembre
 */
public interface IFileSystemContent extends IDetachable {

    Component newContentComponent(
            String id, AbstractTree<File> tree, IModel<File> model);

    File[] getSelectedFiles();
    boolean isSelected(File file);
    void nodeClicked(
            File file, AbstractTree<File> tree, final AjaxRequestTarget target);
    
}
