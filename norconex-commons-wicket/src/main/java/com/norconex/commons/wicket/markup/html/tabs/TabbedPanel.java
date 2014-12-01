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
package com.norconex.commons.wicket.markup.html.tabs;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;

import com.norconex.commons.wicket.behaviors.OnClickBehavior;

/**
 * An {@link AjaxTabbedPanel} with a "light" style attached. To avoid CSS
 * conflicts with Wicket <code>TabbedPanel</code>, the tab container and panel
 * container CSS classes are: <code>nx-commons-tab-row</code> and
 * <code>nx-commons-tab-panel</code>.  Tabs can optionally be made closable.
 * @author Pascal Essiembre
 *
 * @param <T> tab class
 */
public class TabbedPanel<T extends ITab> extends AjaxTabbedPanel<T> {

    private static final long serialVersionUID = 354269521511381786L;

    private final boolean tabsClosable;

    /**
     * Create a new TabbedPanel.  Tabs are not closable.
     * @param id component id
     * @param tabs the tabs
     */
    public TabbedPanel(String id, List<T> tabs) {
        this(id, tabs, false);
    }
    /**
     * Create a new TabbedPanel.
     * @param id component id
     * @param tabs the tabs
     * @param tabsClosable <code>true</code> to render tabs which can be
     * closed.
     */
    public TabbedPanel(String id, List<T> tabs, boolean tabsClosable) {
        super(id, tabs);
        this.tabsClosable = tabsClosable;
        setOutputMarkupId(true);
    }

    @Override
    protected String getTabContainerCssClass() {
        return "nx-commons-tab-row";
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(
                new CssResourceReference(
                        TabbedPanel.class,
                        TabbedPanel.class.getSimpleName() + ".css")));
    }

    /**
     * Gets whether tabs are closable or not.
     * @return <code>true</code> if closable
     */
    public boolean isTabsClosable() {
        return tabsClosable;
    }

    @Override
    protected Component newTitle(
            final String titleId, final IModel<?> titleModel, final int index) {
        if (tabsClosable) {
            return new TitlePanel(titleId, titleModel, index);
        }
        return super.newTitle(titleId, titleModel, index);
    }

    /**
     * This method can optionally be implemented to be notified when a tab
     * is closed.  Only applicable when {@link #isTabsClosable()} returns
     * <code>true</code>. Default implementation does nothing.
     * @param target ajax request target
     * @param index index of tab being closed
     */
    protected void tabClosed(
            AjaxRequestTarget target, int index) {};

    private class TitlePanel extends Panel {
        private static final long serialVersionUID = -3490469330294276881L;
        public TitlePanel(String id, IModel<?> titleModel, final int index) {
            super(id);
            add(new Label("title", titleModel));
            add(new WebMarkupContainer("closeIcon").add(new OnClickBehavior() {
                private static final long serialVersionUID = -1;
                @Override
                protected void onClick(AjaxRequestTarget target) {
                    int selected = getSelectedTab();
                    if (selected > index) {
                        setSelectedTab(selected -1);
                    }
                    getTabs().remove(index);
                    target.add(TabbedPanel.this);
                    tabClosed(target, index);
                }
            }));
        }
    }
}
