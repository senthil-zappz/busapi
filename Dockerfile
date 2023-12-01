#
# Build stage
#
WORKDIR /devopsdemo

FROM maven:3.6.3-openjdk-17 AS build

COPY src /home/app/src

COPY pom.xml /home/app

RUN mvn -B -DskipTests -f /home/app/pom.xml clean package

#
# Package stage
#

FROM openjdk:17-jdk-slim

COPY  --from=build /home/app/target/*.jar busservices-api.jar

ENTRYPOINT ["java","-jar","-Dserver.port=$PORT","busservices-api.jar"]
