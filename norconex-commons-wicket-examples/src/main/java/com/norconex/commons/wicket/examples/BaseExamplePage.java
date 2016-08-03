package com.norconex.commons.wicket.examples;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.norconex.commons.wicket.bootstrap.resources.BootstrapLibrariesContributor;
import com.norconex.commons.wicket.markup.head.JQueryLibrariesContributor;
import com.norconex.commons.wicket.markup.html.CssPage;
import com.norconex.commons.wicket.markup.html.chart.jqplot.resources.JQPlotLibrariesContributor;


// Extends CssPage, which detects .css of same name or package.css
public class BaseExamplePage extends CssPage {

    private static final long serialVersionUID = 102965086592855120L;

    public BaseExamplePage() {
        super();
    }

    public BaseExamplePage(IModel<?> model) {
        super(model);
    }

    public BaseExamplePage(PageParameters pageParameters) {
        super(pageParameters);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        JQueryLibrariesContributor.contribute(getApplication(), response);  
        BootstrapLibrariesContributor.contribute(response);
        JQPlotLibrariesContributor.contribute(response);
    }

}
