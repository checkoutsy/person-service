FROM eclipse-temurin:23

WORKDIR /app

COPY target/person-0.0.1-SNAPSHOT.jar /app/person-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/person-service.jar"]
