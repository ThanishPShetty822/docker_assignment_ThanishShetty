FROM eclipse-temurin:25
LABEL authors="ThanishPShetty(Ext)"

WORKDIR /app

COPY target/docker_assignment_ThanishShetty-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]

