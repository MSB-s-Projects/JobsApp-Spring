FROM openjdk:24-jdk
VOLUME /tmp
COPY FirstJobApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
