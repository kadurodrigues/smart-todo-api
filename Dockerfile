# Build stage: Use a Maven image with JDK 17 to build the application
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage: Use a lightweight JDK 17 image to run the application
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/smart-todo-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]