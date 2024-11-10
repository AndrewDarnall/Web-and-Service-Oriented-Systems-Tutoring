# Use the official Tomcat image as a base
FROM tomcat:10-jdk17

# Copy your servlet WAR file into the Tomcat webapps directory
# Replace 'your-servlet.war' with the actual name of your WAR file
COPY ./web-app/target/DemoApp.war /usr/local/tomcat/webapps/DemoApp.war

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
