package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


@SuppressWarnings("nls")
public class RelativeOverlay extends Behavior {// implements IHeaderContributor {

    private static final long serialVersionUID = 6622078397426028561L;
    private Component component;
    private final Component anchorComponent;
    
    public RelativeOverlay(Component anchorComponent) {
        super();
        this.anchorComponent = anchorComponent;
        anchorComponent.setOutputMarkupId(true);
    }    

    @Override
    public void bind(Component component) {
        super.bind(component);
        this.component = component;
        this.component.setOutputMarkupId(true);
        this.component.add(new CssStyle("display:none"));
    }

    @Override
    public void renderHead(
            Component component, IHeaderResponse response) {
        String anchorId = "$(\"#" + anchorComponent.getMarkupId() + "\")";
        String overlayId = "$(\"#" + component.getMarkupId() + "\")";;
        String mouseInsideVar = "mouseInside" + component.getMarkupId();
        response.render(OnDomReadyHeaderItem.forScript(
                anchorId + ".click(function() {"
              + "var pos = " + anchorId + ".offset();"
              + "var width = " + anchorId + ".width();"
              + overlayId + ".css( {"
              + "\"left\": (pos.left) + \"px\","
              + "\"position\": \"absolute\","
              + "\"display\": \"none\","
              + "\"z-index\": \"1000\","
              + "\"min-width\": width + \"px\""
              + "});"
              + overlayId + ".show();"
              + "});"

              + "var " + mouseInsideVar + " = false;"
              + overlayId + ".hover(function(){"
              + mouseInsideVar + "=true;"
              + "}, function(){"
              + mouseInsideVar + "=false;"
              + "});"

              + "$(document).mouseup(function(){"
              + "if(! " + mouseInsideVar + ") " + overlayId + ".hide();"
              + "});"
        ));
    }
}