# Build stage
FROM maven:3.8.4-openjdk-8-slim AS build
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:8-jre-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
