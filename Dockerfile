FROM amazoncorretto:8-alpine-jdk
MAINTAINER BautistaVarela
COPY target/back-end-0.0.1-SNAPSHOT.jar backend-portfolio.jar
ENTRYPOINT ["java","-jar","/backend-portfolio.jar"]