package com.norconex.commons.wicket.markup.html.dialog;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.CssResourceReference;

import com.googlecode.wicket.jquery.ui.JQueryIcon;
import com.googlecode.wicket.jquery.ui.form.button.AjaxButton;
import com.googlecode.wicket.jquery.ui.panel.JQueryFeedbackPanel;
import com.googlecode.wicket.jquery.ui.widget.dialog.AbstractFormDialog;
import com.googlecode.wicket.jquery.ui.widget.dialog.DialogButton;
import com.norconex.commons.wicket.behaviors.Title;
import com.norconex.commons.wicket.markup.html.filesystem.FileSystemNavigator;
import com.norconex.commons.wicket.markup.html.filesystem.FileSystemTreeProvider;
import com.norconex.commons.wicket.markup.html.filesystem.MultiSelectableFolderContent;
import com.norconex.commons.wicket.markup.html.filesystem.SelectableFolderContent;
import com.norconex.commons.wicket.markup.html.form.IsolatedForm;
import com.norconex.commons.wicket.resource.loader.StringResourceLoaderUtil;

@SuppressWarnings("nls")
public abstract class FileSystemDialog extends AbstractFormDialog<String> {

    private static final long serialVersionUID = -4405452732191628294L;

    //TODO have custom serializable version
    transient private FileFilter selectionValidator;
    private final FileSystemNavigator navigator;
    private final WebMarkupContainer navWrapper;
    private final boolean multiSelectEnabled;
    private final String homeDir = System.getProperty("user.home");
    private Form<Void> dialogForm;

    private final DialogButton btnOK;
    private final DialogButton btnCancel;

    public FileSystemDialog(String id, IModel<String> title) {
        this(id, title, null);
    }
    public FileSystemDialog(
            String id, IModel<String> title, boolean multiSelectEnabled) {
        this(id, title, null, multiSelectEnabled);
    }
    public FileSystemDialog(
            String id, IModel<String> title, FilenameFilter filenameFilter) {
        this(id, title, filenameFilter, false);
    }
    public FileSystemDialog(
            String id, IModel<String> title, FilenameFilter filenameFilter,
            boolean multiSelectEnabled) {
        super(id, title, new Model<String>());

        this.btnOK = new DialogButton(StringResourceLoaderUtil.getString(
                getClass(), "btn.chose"), JQueryIcon.CHECK);
        this.btnCancel = new DialogButton(StringResourceLoaderUtil.getString(
                getClass(), "btn.cancel"), JQueryIcon.CANCEL);

        this.multiSelectEnabled = multiSelectEnabled;
        this.navigator = new FileSystemNavigator("fileSystemNavigator");
        navigator.getTreeProvider().setFileNameFilter(filenameFilter);
        if (multiSelectEnabled) {
            navigator.setFileSystemContent(new MultiSelectableFolderContent(
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
        add(navWrapper);


        dialogForm = new IsolatedForm<Void>("dialogForm");
        dialogForm.add(new IFormValidator() {
            private static final long serialVersionUID = 2226366198621473423L;
            @Override
            public FormComponent<?>[] getDependentFormComponents() {
                return new FormComponent[]{};
            }
            @Override
            public void validate(Form<?> form) {
                File[] files = navigator.getSelectedFiles();
                if (files == null || files.length == 0) {
                    dialogForm.error(getString("err.noselect"));
                } else {
                    for (File file : files) {
                        if (file == null) {
                            dialogForm.error(getString("err.noselect"));
                        } else if (selectionValidator != null
                                && !selectionValidator.accept(file)) {
                            dialogForm.error(getString("err.invalidselect")
                                    + file);
                        }
                    }
                }
            }
        });
        final JQueryFeedbackPanel feedback =
                new JQueryFeedbackPanel("feedback");
        feedback.setOutputMarkupId(true);
        feedback.setOutputMarkupPlaceholderTag(true);
        dialogForm.add(feedback);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

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
    }

    @Override
    protected void onBeforeRender() {
        addOrReplace(dialogForm);
//        final JQueryFeedbackPanel feedback =
//                new JQueryFeedbackPanel("feedback");
//        feedback.setOutputMarkupId(true);
//        feedback.setOutputMarkupPlaceholderTag(true);
//        dialogForm.addOrReplace(feedback);
        super.onBeforeRender();
    }

    @Override
    public Form<Void> getForm() {
        return dialogForm;
    }
    @Override
    protected DialogButton getSubmitButton() {
        return btnOK;
    }

    @Override
    protected void onError(AjaxRequestTarget target) {
        target.add(getForm().get("feedback"));
    }

    @Override
    protected List<DialogButton> getButtons() {
        return Arrays.asList(btnOK, btnCancel);
    }

    @Override
    protected void onOpen(AjaxRequestTarget target) {
        resetTreeProvider(target, homeDir);
    }

    @Override
    protected void onSubmit(AjaxRequestTarget target) {
        onSubmit(target, navigator.getSelectedFiles());
    }

    protected abstract void onSubmit(
            AjaxRequestTarget target, File[] selectedFiles);

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

    private void resetTreeProvider(
            AjaxRequestTarget target, String rootDir) {
        FileSystemTreeProvider provider = navigator.getTreeProvider();
        FilenameFilter filter = provider.getFileNameFilter();
        provider = new FileSystemTreeProvider(rootDir);
        provider.setFileNameFilter(filter);
        navigator.setTreeProvider(provider);
        if (multiSelectEnabled) {
            navigator.setFileSystemContent(
                    new MultiSelectableFolderContent(provider));
        } else {
            navigator.setFileSystemContent(
                    new SelectableFolderContent(provider));
        }
        navWrapper.addOrReplace(navigator);
        target.add(dialogForm);
        target.add(navWrapper);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(new CssResourceReference(
                FileSystemDialog.class, "wicket-package.css")));
    }
}


