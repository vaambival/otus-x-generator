FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY pom.xml ./
COPY /src ./src/
RUN mvn package

FROM openjdk:21 AS runner
WORKDIR /app
COPY --from=builder /app/target/otus-x-generator-0.0.1-SNAPSHOT.jar generator.jar
CMD ["java", "-jar", "/app/generator.jar"]

