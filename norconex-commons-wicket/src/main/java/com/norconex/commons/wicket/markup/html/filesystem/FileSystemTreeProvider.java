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
package com.norconex.commons.wicket.markup.html.filesystem;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.lang3.SystemUtils;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Tree provider implementation that allows for file filtering and
 * supports file system roots (i.e. letter drives on Windows).
 * @author Pascal Essiembre
 */
public class FileSystemTreeProvider implements ITreeProvider<File> {

    private static final long serialVersionUID = -5112358258271599837L;

    private final File root;
    private transient FilenameFilter fileNameFilter;
        //TODO come up with serializable filter?? Or custom filtering class?

    public FileSystemTreeProvider() {
        this(SystemUtils.USER_HOME);
    }

    public FileSystemTreeProvider(String startPath) {
        root = new File(startPath);
    }

    @Override
    public void detach() {
        // do nothing by default
    }

    @Override
    public Iterator<? extends File> getRoots() {
        if (isWindowsRoot(root)) {
            return Arrays.asList(File.listRoots()).iterator();
        }
        return Arrays.asList(root.listFiles(fileNameFilter)).iterator();
    }

    @Override
    public boolean hasChildren(File node) {
        if (node.isDirectory()) {
            String[] children = node.list(fileNameFilter);
            return children != null && children.length > 0;
        }
        return false;
    }

    @Override
    public Iterator<? extends File> getChildren(File node) {
        if (node != null) {
            File[] files = node.listFiles(fileNameFilter);
            if (files != null) {
                return Arrays.asList(files).iterator();
            }
        }
        return new ArrayList<File>().iterator();
    }

    @Override
    public IModel<File> model(File object) {
        return new Model<File>(object);
    }

    public FilenameFilter getFileNameFilter() {
        return fileNameFilter;
    }

    public void setFileNameFilter(FilenameFilter fileNameFilter) {
        this.fileNameFilter = fileNameFilter;
    }

    public static boolean isWindowsRoot(File file) {
    	return SystemUtils.IS_OS_WINDOWS && file.getPath().equals(
    			SystemUtils.FILE_SEPARATOR);
    }
    public static boolean isUserHomeRoot(File file) {
        return file.getPath().equals(SystemUtils.USER_HOME);
    }
}

