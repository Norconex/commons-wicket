package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.model.IDetachable;
import org.apache.wicket.model.IModel;

/**
 * Base class for file system content components, influencing how nodes 
 * will be rendered and behave.
 * @author Pascal Essiembre
 */
public abstract class FileSystemContent implements IDetachable {

    private static final long serialVersionUID = 3028538115649384538L;

    public abstract Component newContentComponent(
            String id, AbstractTree<File> tree, IModel<File> model);

    public abstract File[] getSelectedFiles();
    
    @Override
    public void detach() {
        // do nothing by default
    }
}
