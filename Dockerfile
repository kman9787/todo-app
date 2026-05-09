# Use a lightweight base image
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/*.jar app.jar

# Optional: Set a default environment variable
ENV PROFILE=DEV

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
