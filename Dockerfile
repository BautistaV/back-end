FROM amazoncorretto:8-alpine-jdk
MAINTAINER BautistaVarela
COPY target/back-end-0.0.1-SNAPSHOT.jar back-end.jar
ENTRYPOINT ["java","-jar","/back-end.jar"]