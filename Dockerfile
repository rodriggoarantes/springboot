FROM gcr.io/distroless/java17-debian11

COPY ./target/spring-hello-world*.jar /app/application.jar

WORKDIR /app

CMD ["application.jar"]