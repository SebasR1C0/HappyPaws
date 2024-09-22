FROM openjdk:22
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/HappyPaws-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} happy-paws.jar
ENTRYPOINT ["java", "-jar", "/happy-paws.jar"]