# Build stage
FROM maven:3.8.5-openjdk-17 AS build

COPY ./src /home/app/src
COPY ./pom.xml /home/app
RUN mvn clean install -f /home/app/pom.xml -DskipTests

#
# Package stage
#
#FROM openjdk:8-jdk-alpine
FROM openjdk:17-slim
WORKDIR /usr/src
COPY --from=build /home/app/target/quarkus-app /usr/local/lib/quarkus-app
EXPOSE 8080
ENTRYPOINT ["java","-Dquarkus.profile=prod", "-jar","/usr/local/lib/quarkus-app/quarkus-run.jar"]
