FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/busapi-0.0.1-SNAPSHOT.jar busservices-api.jar

ENTRYPOINT ["java","-jar","busservices-api.jar"]

