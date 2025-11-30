# Use Java 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory in the container
WORKDIR /app

# Copy the built JAR from target folder to container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
