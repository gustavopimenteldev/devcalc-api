FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/devcalc-api-1.0.0-jar-with-dependencies.jar app.jar

EXPOSE 7000

ENTRYPOINT ["java", "-jar", "app.jar"]
