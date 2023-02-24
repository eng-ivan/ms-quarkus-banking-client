FROM openjdk:11-jdk-slim
LABEL key="core.ics"
EXPOSE 8081
RUN mkdir app
WORKDIR /app
ARG JAR_FILE=target/*.jar
ADD /target/${JAR_FILE} /app/ms-quarkus-banking-client-0.1.1.jar
ENTRYPOINT [ "java", "-jar", "ms-quarkus-banking-client-0.1.1.jar" ]