FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/bookingapi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} bookingapi.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "bookingapi.jar" ]