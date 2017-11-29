package launch;

import java.io.File;
import java.io.FileInputStream;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    final static Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) throws Exception {
        
        String contextPath = "/";
        String webappDirLocation = "src/main/webapp/";
        String baseDirectory = new File(webappDirLocation).getAbsolutePath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);
        
        // Additions to make @WebServlet work
        String buildPath       = "target/classes";
        String webInfClassPath = "/WEB-INF/classes";
        String resourcePath    = "/src/main/resources"; //TODO: Find how to add multiple static folders

        File additionalWebInfClasses  = new File(buildPath);
        File additionalWebInfClasses2 = new File(resourcePath);
        WebResourceRoot webRoot = new StandardRoot(context);
        webRoot.addPreResources(new DirResourceSet(webRoot , webInfClassPath, additionalWebInfClasses.getAbsolutePath(), contextPath));
        context.setResources(webRoot);
        

        logger.error("\n************** Logging Only Errors to Console ***************\n ");
        
        //Printing Classpath(s)
        System.out.println("\n *** ClassPath *** ");
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        for(URL url: urls){
            System.out.println(url.getFile());
        }
        
        //Pringting System Properties
        System.out.println("\n *** Some System Properties *** ");
        System.out.println("user.home     :" + System.getProperty("user.home"));
        System.out.println("user.dir      :" + System.getProperty("user.dir"));
        System.out.println("catalina.home :" + System.getProperty("catalina.home"));
        System.out.println("catalina.base :" + System.getProperty("catalina.base") +"\n\n");

        System.out.println(ClassLoader.getSystemResource("log4j2.json")); 
        
        tomcat.start();
        tomcat.getServer().await();
    }
}
