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
            new MockWebResponse()));        
    }
}
