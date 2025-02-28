# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file from target directory
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
