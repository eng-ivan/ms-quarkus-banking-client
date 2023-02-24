FROM openjdk:11
LABEL key="core.ics"
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ADD target/ms-quarkus-banking-client-0.1.1.jar ms-quarkus-banking-client-0.1.1.jar
COPY ${JAR_FILE} ms-quarkus-banking-client-0.1.1.jar
CMD [ "java", "-jar", "ms-quarkus-banking-client-0.1.1.jar" ]


