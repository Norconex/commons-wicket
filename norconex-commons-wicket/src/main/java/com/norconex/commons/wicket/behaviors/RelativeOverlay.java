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
package com.norconex.commons.wicket.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;


/**
 * Anchors a component relative to another one as an overlay.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
public class RelativeOverlay extends Behavior {

    private static final long serialVersionUID = 6622078397426028561L;
    private final Component anchorComponent;
    
    public RelativeOverlay(Component anchorComponent) {
        super();
        this.anchorComponent = anchorComponent;
        anchorComponent.setOutputMarkupId(true);
    }    

    @Override
    public void bind(Component component) {
        super.bind(component);
        component.setOutputMarkupId(true);
        component.add(new CssStyle("display:none"));
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