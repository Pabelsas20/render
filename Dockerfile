FROM amazoncorretto:21-alpine-jdk

COPY boot/target/boot-0.0.1-SNAPSHOT.jar /v1.jar

ENTRYPOINT ["java", "-jar", "/v1.jar"]