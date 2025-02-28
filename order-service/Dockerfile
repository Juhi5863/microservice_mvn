# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file from target directory (ensure you have built the JAR using `mvn clean package`)
COPY target/*.jar app.jar

# Expose the port for the service
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
