# Java Servlets

A Java servlet is a server-side technology used for developing dynamic web applications in Java. It runs on the server and handles client requests and generates dynamic web content as responses. Servlets are part of the Java EE (Enterprise Edition) platform and are deployed on servlet containers (e.g., Apache Tomcat, Jetty, and more)

----

## Initializing the project with Apache Maven


Initialize the Servlet project with the appropriate directory structure using the following command: 

mvn archetype:generate -DgroupId=com.drew -DartifactId=web-app -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

(Tweak the parameters as needed)

----

## Hosting

There are two options when it comes to 'testing' locally a Java servlet, either by downloading Apache Tomcat (version >= 10) and running the servlet locally {Not advisable} or by dockerizing the Apache Tomcat server and deploying the servlet to the container, this step requires some additional configuration of the Docker runtime and perhaps a connection to a DevOps pipeline using tools such as Jenkins.

A simpler way to deploy a Java Servlet is to embed a servlet engine within the app itself using the eclipse jetty servlet container (injected as a dependency via the Apache Maven build system)

----

## The Project's Structure

Upon generation, a Maven generated servlet project has a simple structure:

- src
- webapp/WEB-INF
- pom.xml

After running the mvn clean install, the entire lifecycle defined in the pom.xml will be executed, generating a 'target' directory where all the .class files, test files and built arficats will be deployed to

Alternatively, there might be other directories which serve various purposes, such as the assets directory, for various types of web app assets, such as the imaegs
There might be a data directory, for integration with a data pipeline or even an sql directory for DDL DB Schema definitions or migration files

What you'll find in a real-world work environment really depends on the product's (and client's) needs from the Web App

Maven has many commands, other types of commands can simply trigger a packaging of the project, without the execution

----

## The WEB-INF directory

The directory holds the web.xml file which has the definitions of the servlet's mappings, in other words it is the configuration file for what would be explicitly programmed in a JavaScript framework such as express.js

----

## Running the app

After all required depencencies have been downloaded to the local maven repository during the initial
build phase, and after including the Jetty dependency, the web app can be run via the 'mvn jetty:run' 
command

-> Remember that the path binding (context path) and the port binding are defined in the pom.xml
-> Make sure you are in the book-store directory (within the project itself) before running any maven command

----

# References

- 1) [Apache Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- 2) [Maven Web App Archetype](https://maven.apache.org/archetypes/maven-archetype-webapp/)
