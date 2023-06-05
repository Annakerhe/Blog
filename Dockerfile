FROM openjdk:17-alpine3.14
WORKDIR /app
COPY ./target/*.jar /app/service.jar
ENTRYPOINT ["java", "-jar", "/app/service.jar"]
EXPOSE 8080