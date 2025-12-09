# Imagem base com JDK 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o JAR já empacotado (com dependências)
COPY target/devcalc-api-1.0.0-jar-with-dependencies.jar app.jar

EXPOSE 7000

ENTRYPOINT ["java", "-jar", "app.jar"]
