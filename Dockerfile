# Etapa 1: Construção
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Rodar o Sistema
# AQUI ESTAVA O ERRO: Trocamos para uma imagem que funciona 100%
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]