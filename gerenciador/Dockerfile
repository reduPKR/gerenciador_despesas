FROM openjdk:17
MAINTAINER Rafael Eduardo
WORKDIR /app
COPY /target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]