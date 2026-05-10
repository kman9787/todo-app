# Build the application
FROM docker.io/library/maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copy only the pom.xml first to leverage Docker cache for dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the package
COPY src ./src
RUN mvn clean package -DskipTests

# Use a lightweight base image
FROM docker.io/library/eclipse-temurin:21.0.11_10-jre-noble

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/*.jar app.jar

# Optional: Set a default environment variable
ENV PROFILE=DEV

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
