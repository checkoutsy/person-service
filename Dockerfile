FROM eclipse-temurin:23

WORKDIR /app

COPY target/user-0.0.1-SNAPSHOT.jar /app/user-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]
