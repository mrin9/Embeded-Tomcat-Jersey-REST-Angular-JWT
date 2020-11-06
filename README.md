# Embeded-Tomcat-Jersey-REST-Angular-JWT


## Overview
The project generates a self executing fat jar withh all the dependencies bundled in it. When you execute, it will 
 * Start Tomcat server (in embedded mode) 
 * Setup jersey 2 (REST API support, include CORS support)
 * Setup logging for the project (log4j2)
 * Generates Open API spec for the APIs it is exposing (Swagger)


### Build
```mvn clean install```

### Execute
``` java -jar ./target/app-jar-with-dependencies.jar ``` It should start the server at port 8080 and create a log folder


### Some Initial endpoints
Cpmponent           | URL                                      
---                 | ---                                      
Servlet             |  http://localhost:8080/servlet           
JSP                 |  http://localhost:8080/index.jsp
index.html (default)|  http://localhost:8080 or http://localhost:8080/index.html
Jersey App          |  http://localhost:8080/api/auth/message  
Swagger (API Spec)  |  http://localhost:8080/api/swagger.json   
Error Page          |  http://localhost:8080/some-non-existing-page

