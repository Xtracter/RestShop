FROM eclipse-temurin:17-jdk-windowsservercore-ltsc2022

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
