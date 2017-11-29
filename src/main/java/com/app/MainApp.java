package com.app;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import com.app.filter.CORSResponseFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

//@ApplicationPath("api") // (Dont work in a .jar may work in .war )
public class MainApp extends ResourceConfig {
    
   public MainApp(@Context ServletContext servletContext) {
        System.out.print("\nJersey Init\n");
        
        // Register Features
        register(JacksonFeature.class );
        register(MultiPartFeature.class);
        
        // Register Filters 
        register(CORSResponseFilter.class);

        // Regster Source Packages
        packages("io.swagger.jaxrs.json");
        packages("io.swagger.jaxrs.listing");
        packages("com.app.api");
    }
    
}
