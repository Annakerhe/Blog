FROM openjdk:17-alpine3.14 as build
WORKDIR /usr/src/app
COPY mvnw pom.xml ./
COPY src ./src
COPY .mvn ./.mvn
RUN ./mvnw package

FROM build as develop
WORKDIR /app
COPY --from=build /usr/src/app/target/*.jar /app/service.jar
ENTRYPOINT ["java", "-jar", "/app/service.jar"]
EXPOSE 8080