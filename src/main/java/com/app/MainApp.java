package com.app;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import com.app.filter.CORSResponseFilter;

//@ApplicationPath("/api")
public class MainApp extends ResourceConfig {
    
   public MainApp(@Context ServletContext servletContext) {
        System.out.print("JERSEY Init");
        packages("io.swagger.jaxrs.json");
        packages("io.swagger.jaxrs.listing");
        packages("com.app.api");
        register(CORSResponseFilter.class);
        register(MultiPartFeature.class);
    }
    
}
