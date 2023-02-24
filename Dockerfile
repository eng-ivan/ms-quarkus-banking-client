FROM maven:3.8.5-openjdk-11-slim AS build

COPY . .

RUN mvn -f pom.xml clean package -Dmaven.test.skip

FROM openjdk:11

LABEL key="core.ics"

WORKDIR /usr/src/app

COPY --from=build /app/target/*.jar ms-quarkus-banking-client-0.1.1.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "ms-quarkus-banking-client-0.1.1.jar"]