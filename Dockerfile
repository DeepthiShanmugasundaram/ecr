FROM openjdk:slim-buster

WORKDIR /app

COPY ./target/springboot-docker-jenkins-ecr-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]