package com.norconex.commons.wicket.bootstrap.tab;

import java.util.List;

import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.model.IModel;

public class BootstrapTabbedPanel<T extends ITab> extends TabbedPanel<T> {

    private static final long serialVersionUID = 6592096175053864258L;

    public enum TabPosition { 
        TOP(null), RIGHT("tabs-right"), LEFT("tabs-left");
        private final String css;
        TabPosition(String css) {
            this.css = css;
        }
    };
    
    private final TabPosition tabPosition;
    
    public BootstrapTabbedPanel(
            String id, List<T> tabs, IModel<Integer> model) {
        this(id, tabs, model, (TabPosition) null);
    }
    public BootstrapTabbedPanel(String id, List<T> tabs) {
        this(id, tabs, (TabPosition) null);
    }
    public BootstrapTabbedPanel(String id, List<T> tabs, 
            IModel<Integer> model, TabPosition position) {
        super(id, tabs, model);
        this.tabPosition = position;
    }
    public BootstrapTabbedPanel(String id, List<T> tabs, TabPosition position) {
        super(id, tabs);
        this.tabPosition = position;
    }

    @Override
    protected String getTabContainerCssClass() {
        String positionCss = null;
        if (tabPosition != null) {
            positionCss = tabPosition.css;
        }
        if (positionCss == null) {
            return "nav nav-tabs";
        } else {
            return "nav nav-tabs " + positionCss;
        }
    }
    @Override
    protected String getLastTabCssClass() {
        return "";
    }
    @Override
    protected String getSelectedTabCssClass() {
        return "active";
    }
}
