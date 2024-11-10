# Dockerfile for the backend databases
FROM mysql:latest

# With this line you copy the specific .sql script into the appropriate path of the container
COPY ./*.sql /docker-entrypoint-initdb.d/

# This documents the exposure of the port of the container, makes it easier for when you run it
EXPOSE 3306