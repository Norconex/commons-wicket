package com.norconex.commons.wicket.examples;

import java.net.URL;
import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WicketFilter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

@SuppressWarnings("nls")
public class ExamplesServer {
    
    private static final String EXAMPLES_MAPPING = "/examples/*";
    private static final int SERVER_PORT = 8080;
    
    private final Server server = new Server();
    private final ExamplesApplication app;
    
    
    private static ExamplesServer examplesServer;
    
    public ExamplesServer() {
        this.app = new ExamplesApplication();
        init();
    }
    
    public void init() {
        
        app.setConfigurationType(RuntimeConfigurationType.DEVELOPMENT);
        
        WebAppContext webappContext = buildWebappContext();
        ResourceHandler staticHandler = buildStaticResourcesHandler();
        
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { staticHandler, webappContext });
        server.setHandler(handlers);
        
        initHttpConnector();
    }
    
    private WebAppContext buildWebappContext() {
        
        WebAppContext webappContext = new WebAppContext();
        webappContext.setResourceBase("/");
        
        // Add Wicket filter
        WicketFilter filter = new WicketFilter(app);
        FilterHolder filterHolder = new FilterHolder(filter);
        filterHolder.setInitParameter(
                WicketFilter.FILTER_MAPPING_PARAM, EXAMPLES_MAPPING);
        webappContext.addFilter(
                filterHolder, 
                EXAMPLES_MAPPING, 
                EnumSet.of(DispatcherType.REQUEST));
        
        return webappContext;
    }
    
    private ResourceHandler buildStaticResourcesHandler() {
        ResourceHandler staticHandler = new ResourceHandler();
        URL staticResources = 
                ExamplesServer.class.getClassLoader().getResource("static");
        staticHandler.setResourceBase(staticResources.toExternalForm());
        staticHandler.setWelcomeFiles(new String[] {"index.html"});
        staticHandler.setDirectoriesListed(false);
        return staticHandler;
    }
    
    private void initHttpConnector() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(SERVER_PORT);
        server.addConnector(connector);
    }
    
    public void run() throws Exception {
        server.start();
        System.out.println(
                "You can acccess http://localhost:" + SERVER_PORT 
                + EXAMPLES_MAPPING);
        server.join();
    }
    
    public void stop() throws Exception {
        server.stop();
        server.join();
    }

    
    public static void main(String[] args) throws Exception {
        start(args);
    }
    
    public static void start(String[] args) throws Exception {
        
        // this check is to facilitate running as a service
        if (examplesServer != null) {
            System.err.println(
                    "Examples server is already running.");
            return;
        }

        examplesServer = new ExamplesServer();
        
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    examplesServer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        examplesServer.run();
    }
    // Method for when run as a service using procrun
    public static void stop(String[] args) throws Exception {
        if (examplesServer == null) {
            System.err.println("Examples server is not running.");
            return;
        }
        System.out.println(
                "Stopping Norconex Commons Wicket Examples server...");
        examplesServer.stop();
        System.out.println("Stopped.");
        
    }

}
