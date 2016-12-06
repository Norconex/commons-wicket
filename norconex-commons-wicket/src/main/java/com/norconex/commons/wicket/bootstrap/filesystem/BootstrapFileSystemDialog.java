/* Copyright 2012-2016 Norconex Inc.
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
import java.io.FileFilter;
import java.io.FilenameFilter;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

import com.norconex.commons.wicket.behaviors.CssClassAppender;
import com.norconex.commons.wicket.behaviors.Title;
import com.norconex.commons.wicket.bootstrap.modal.BootstrapAjaxModal;
import com.norconex.commons.wicket.bootstrap.modal.BootstrapModalDefaultHeader;
import com.norconex.commons.wicket.markup.html.filesystem.FileSystemNavigator;
import com.norconex.commons.wicket.markup.html.filesystem.FileSystemTreeProvider;

/**
 * A Bootstrap file system dialog component.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public abstract class BootstrapFileSystemDialog extends BootstrapAjaxModal {

    private static final long serialVersionUID = 2910402645549674983L;

    private transient FileFilter selectionValidator;
    private final FileSystemNavigator navigator;
    private final WebMarkupContainer navWrapper;
    private final boolean multiSelectEnabled;
    private final String homeDir = System.getProperty("user.home");
    private final Component feedback = 
            new FeedbackPanel("feedback").setOutputMarkupPlaceholderTag(true);
    
    public BootstrapFileSystemDialog(String id, IModel<String> title) {
        this(id, title, null);
    }
    public BootstrapFileSystemDialog(
            String id, IModel<String> title, boolean multiSelectEnabled) {
        this(id, title, null, multiSelectEnabled);
    }
    public BootstrapFileSystemDialog(
            String id, IModel<String> title, FilenameFilter filenameFilter) {
        this(id, title, filenameFilter, false);
    }
    public BootstrapFileSystemDialog(
            String id, IModel<String> title, FilenameFilter filenameFilter,
            boolean multiSelectEnabled) {
        super(id, title, new Model<String>());

        setOutputMarkupId(true);
        
        add(new CssClassAppender("nx-commons-fsdlg"));
        
        this.multiSelectEnabled = multiSelectEnabled;
        this.navigator = new BootstrapFileSystemNavigator(
                "fileSystemNavigator");
        navigator.getTreeProvider().setFileNameFilter(filenameFilter);
        if (multiSelectEnabled) {
            navigator.setFileSystemContent(new BootstrapMultiSelectableContent(
                    navigator.getTreeProvider()));
        }
        this.navWrapper = new WebMarkupContainer("navigatorWrapper") {
            private static final long serialVersionUID = 8286836115004105516L;
            @Override
            protected void onBeforeRender() {
                navigator.getTreeProvider().setFileNameFilter(
                        getFilenameFilter());
                addOrReplace(navigator);
                super.onBeforeRender();
            }
        };
        navWrapper.setOutputMarkupId(true);
        //do stuff...
    }
    
    @Override
    protected Component createHeaderComponent(String id) {
        return new BootstrapModalDefaultHeader(
                id, getTitle(), "fa fa-folder-open-o");
    }
    @Override
    protected Component createBodyComponent(String markupId) {
        return new Body(markupId);
    }
    @Override
    protected Component createFooterComponent(String id) {
        return new Footer(id);
    }
    
    public FilenameFilter getFilenameFilter() {
        return navigator.getTreeProvider().getFileNameFilter();

    }
    public void setFilenameFilter(FilenameFilter filenameFilter) {
        navigator.getTreeProvider().setFileNameFilter(filenameFilter);
    }

    public FileFilter getSelectionValidator() {
        return selectionValidator;
    }
    public void setSelectionValidator(FileFilter selectionValidator) {
        this.selectionValidator = selectionValidator;
    }

    protected abstract void onSubmit(
            AjaxRequestTarget target, File[] selectedFiles);
    
    private void resetTreeProvider(
            AjaxRequestTarget target, String rootDir) {
        FileSystemTreeProvider provider = navigator.getTreeProvider();
        FilenameFilter filter = provider.getFileNameFilter();
        provider = new FileSystemTreeProvider(rootDir);
        provider.setFileNameFilter(filter);
        navigator.setTreeProvider(provider);
        if (multiSelectEnabled) {
            navigator.setFileSystemContent(
                    new BootstrapMultiSelectableContent(provider));
        } else {
            navigator.setFileSystemContent(
                    new BootstrapSelectableContent(provider));
        }
        navWrapper.addOrReplace(navigator);
        target.add(navWrapper);
    }
    
    private class Body extends Panel {
        private static final long serialVersionUID = 914125064944803011L;
        public Body(String id) {
            super(id);
            
            AjaxButton homeButton = new AjaxButton("home") {
                private static final long serialVersionUID =
                        5743601460587059505L;
                @Override
                protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    resetTreeProvider(target, homeDir);
                }
            };
            homeButton.setDefaultFormProcessing(false);
            homeButton.add(new Title(new ResourceModel("btn.home.alt")));
            AjaxButton rootButton = new AjaxButton("root") {
                private static final long serialVersionUID =
                        5139526986732199148L;
                @Override
                public void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    resetTreeProvider(target, "/");
                }
            };
            rootButton.add(new Title(new ResourceModel("btn.root.alt")));
            rootButton.setDefaultFormProcessing(false);
            add(homeButton);
            add(rootButton);
            
            
            add(navWrapper);
            add(feedback);
        }
    }
    
    private class Footer extends Panel {
        private static final long serialVersionUID = 4186844492615693026L;
        private final Form<?> form;
        public Footer(String id) {
            super(id);
            this.form = new Form<Void>("form");;
            form.add(new IFormValidator() {
                private static final long serialVersionUID = 2226366198621473423L;
                @Override
                public FormComponent<?>[] getDependentFormComponents() {
                    return new FormComponent[]{};
                }
                @Override
                public void validate(Form<?> form) {
                    File[] files = navigator.getSelectedFiles();
                    if (files == null || files.length == 0) {
                        form.error(getString("err.noselect"));
                    } else {
                        for (File file : files) {
                            if (file == null) {
                                form.error(getString("err.noselect"));
                            } else if (selectionValidator != null
                                    && !selectionValidator.accept(file)) {
                                form.error(getString("err.invalidselect")
                                        + file);
                            }
                        }
                    }
                }
            });
            
            form.add(new AjaxSubmitLink("submit", form) {
                private static final long serialVersionUID = 
                        2863084303922306231L;
                @Override
                protected void onError(AjaxRequestTarget target, Form<?> form) {
                    target.add(feedback);
                }
                @Override
                protected void onSubmit(
                        AjaxRequestTarget target, Form<?> form) {
                    hide(target);
                    BootstrapFileSystemDialog.this.onSubmit(
                            target, navigator.getSelectedFiles());
                }
            });
            
            add(form);
        }
    }
}


