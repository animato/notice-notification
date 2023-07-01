FROM openjdk:11-jdk
VOLUME /tmp
COPY build/libs/*.jar mock-telegram.jar
ENTRYPOINT ["java","-jar","/mock-telegram.jar"]