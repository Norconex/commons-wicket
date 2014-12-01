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
package com.norconex.commons.wicket;

import java.io.Serializable;

import org.apache.commons.lang3.SystemUtils;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.ThreadContext;
import org.apache.wicket.mock.MockWebRequest;
import org.apache.wicket.mock.MockWebResponse;
import org.apache.wicket.protocol.http.mock.MockHttpServletRequest;
import org.apache.wicket.protocol.http.mock.MockHttpSession;
import org.apache.wicket.protocol.http.mock.MockServletContext;
import org.apache.wicket.request.Url;

/**
 * Fake Wicket thread context to help in using Wicket components or features
 * out of a genuine Wicket context.
 * @author Pascal Essiembre
 *
 */
public class ThreadContextMocker implements Serializable {

    private static final long serialVersionUID = 2979932039925529830L;

    private final Application application;
    private final Session session;

    /**
     * Invoke the constructor in the current wicket request.
     */
    public ThreadContextMocker() {
        super();
        this.application = Application.get();
        this.session = Session.get();
    }

    /**
     * Invoke this method in the new thread before doing something with Wicket.
     */
    public void mock() {
        ThreadContext.setApplication(application);
        ThreadContext.setSession(session);
        final MockServletContext context = 
                new MockServletContext(application, SystemUtils.JAVA_IO_TMPDIR);
        ThreadContext.setRequestCycle(
            application.createRequestCycle(new MockWebRequest(
                    Url.parse("http://localhost/mock")) {
                @Override
                public Object getContainerRequest() {
                    return new MockHttpServletRequest(
                            application, new MockHttpSession(context), context);
                }
            },
            new MockWebResponse())
        );        
    }
}
