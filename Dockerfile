FROM openjdk:24-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} AplicativoReservaCasa-0.0.1.jar
ENTRYPOINT ["java","-jar","/AplicativoReservaCasa-0.0.1.jar"]