# Java Servlets

A Java `servlet` is a server-side technology used for developing `dynamic web applications` in Java. It runs on the server and handles client requests and generates `dynamic web content` as responses. Servlets are part of the `Java EE (Enterprise Edition)` platform and are deployed on `servlet containers` (e.g., Apache Tomcat, Jetty, and more)

----

## Initializing the project with Apache Maven


Initialize the Servlet project with the appropriate directory structure using the following command: 

```bash
mvn archetype:generate -DgroupId=com.drew -DartifactId=web-app -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

(Tweak the parameters as needed)

----

## Hosting

There are two options when it comes to 'testing' locally a Java servlet, either by downloading `Apache Tomcat` (version >= 10) and running the servlet locally {Not advisable} or by `containerizing` the Apache Tomcat server with `docker` and uploading the code into the `docker image` and then running the container, this step requires some additional configuration of the `Docker runtime`.
<br>
<br>
The container image can also be built and run using `Apache Maven`, by using the appropriate `pipeline` and `plugins`

A simpler way to deploy a Java Servlet is to `embed` a servlet engine within the app itself using the `eclipse jetty` servlet container (injected as a dependency via the Apache Maven build system)

----

# The Examples

```bash
.
└── 01-Intro-Servlet
```

- `01-Intro-Servlet` is a basic example of the structure of a Servlet
