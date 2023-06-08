FROM openjdk:17-alpine3.14 as build
WORKDIR /blogapp
COPY ./ ./
CMD ["./mvnv", "install"]

FROM build
WORKDIR /app
COPY ./target/*.jar /app/service.jar
ENTRYPOINT ["java", "-jar", "/app/service.jar"]
EXPOSE 8080