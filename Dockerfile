FROM openjdk:19-jdk-alpine
COPY target/analista-desarrollo-0.0.1-SNAPSHOT.jar /analista_desarrollo.jar
EXPOSE 9090
CMD ["java", "-jar", "/analista_desarrollo.jar"]