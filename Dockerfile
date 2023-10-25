FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY target/busapi-0.0.1-SNAPSHOT.jar busservices-api.jar
ENTRYPOINT ["java","-jar","/busservices-api.jar"]

