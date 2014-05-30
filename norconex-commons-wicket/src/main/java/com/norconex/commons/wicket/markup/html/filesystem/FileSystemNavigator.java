package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.extensions.markup.html.repeater.tree.NestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.SetModel;

import com.norconex.commons.wicket.markup.html.dialog.FileSystemDialog;
import com.norconex.commons.wicket.markup.html.panel.CssPanel;

/**
 * A component that allows browsing the server file system. 
 * The default constructor
 * will start the navigator in the application user home directory and will
 * allow only one folder/file selection.  To change the starting directory,
 * you can supply your own instance of a {@link FileSystemTreeProvider}.
 * To allow for multiple selections, call the 
 * {@link #setFileSystemContent(FileSystemContent)} method with an instance
 * of {@link MultiSelectableFolderContent}.
 * @see FileSystemDialog
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class FileSystemNavigator extends CssPanel {

    private static final long serialVersionUID = -1426312420899669373L;

    private NestedTree<File> tree;
    private FileSystemContent content;
    
    /**
     * Creates a single-select navigator starting in the application
     * user home directory.
     * @param id Wicket component id
     */
    public FileSystemNavigator(String id) {
        this(id, null);
    }

    /**
     * Creates a single-select navigator as per the tree provider specified.
     * @param id Wicket component id
     * @param model file system tree provider
     */
    public FileSystemNavigator(
            String id, IModel<FileSystemTreeProvider> model) {
        super(id, model == null
                ? new Model<ITreeProvider<File>>(
                        new FileSystemTreeProvider()): model);
        setOutputMarkupId(true);
        content = new SelectableFolderContent(getTreeProvider());
    }
    
    /**
     * Gets the content component used to render nodes.
     * @return content component
     */
    public FileSystemContent getFileSystemContent() {
        return content;
    }
    /**
     * Sets the content component used to render nodes.
     * @param content the content component
     */
    public void setFileSystemContent(FileSystemContent content) {
        this.content = content;
    }
    
    @Override
    protected void onBeforeRender() {
        final FileSystemTreeProvider treeProvider = getTreeProvider();
        IModel<Set<File>> model = new SetModel<File>(new HashSet<File>());
        tree = new DefaultNestedTree<File>("navigator", treeProvider, model) {
            private static final long serialVersionUID = -6251279132840692219L;
            @Override
            protected Component newContentComponent(
                    String id, IModel<File> node) {
                return getFileSystemContent().newContentComponent(
                        id, tree, node);
            }
            
        }; 
        addOrReplace(tree);
        super.onBeforeRender();
    }
    
    
    /**
     * Gets the file currently selected.  In the event of multiple selections,
     * only the first selection is returned.
     * @return the selected file
     */
    public File getSelectedFile() {
        File[] files = getSelectedFiles();
        if (files != null && files.length > 0) {
            return files[0];
        }
        return null;
    }
    /**
     * Gets all files currently selected, or an empty array if no files are 
     * selected (this method is null-safe).
     * @return selected files
     */
    public File[] getSelectedFiles() {
        return content.getSelectedFiles();
    }
    
    /**
     * Gets the file system tree provider.
     * @return the provider
     */
    public FileSystemTreeProvider getTreeProvider() {
        return (FileSystemTreeProvider) getDefaultModelObject();
    }
    /**
     * Sets the file system tree provider.
     * @param provider the provider
     */
    public void setTreeProvider(FileSystemTreeProvider provider) {
        setDefaultModelObject(provider);
    }
}
