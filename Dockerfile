# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /usr/app
COPY ./src /usr/app/src
COPY ./pom.xml /usr/app
RUN mvn clean install -f /usr/app/pom.xml -DskipTests

#
# Package stage
#
#FROM openjdk:8-jdk-alpine
FROM openjdk:17-slim
WORKDIR /usr/src
COPY --from=build /usr/app/target/app.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
