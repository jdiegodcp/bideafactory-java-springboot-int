FROM maven:3.8.5-openjdk-17-slim AS build
# Set the working directory inside the container
WORKDIR /app
# Copy the project files to the working directory
COPY . .
# Build the project
RUN mvn clean package -DskipTests
# Use a base image with JDK for the runtime
FROM openjdk:17-jdk-slim
# Set the working directory inside the container
WORKDIR /app
# Copy the JAR file from the build stage to the working directory
COPY --from=build /app/target/bookingapi-0.0.1-SNAPSHOT.jar app.jar
# Expose the port the application runs on
EXPOSE 8080
# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]