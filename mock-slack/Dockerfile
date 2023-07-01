FROM openjdk:11-jdk
VOLUME /tmp
COPY build/libs/*.jar mock-slack.jar
ENTRYPOINT ["java","-jar","/mock-slack.jar"]