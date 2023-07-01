FROM openjdk:11-jdk
VOLUME /tmp
COPY build/libs/*.jar worker-slack.jar
ENTRYPOINT ["java","-jar","/worker-slack.jar"]