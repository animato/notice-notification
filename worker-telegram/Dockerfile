FROM openjdk:11-jdk
VOLUME /tmp
COPY build/libs/*.jar worker-telegram.jar
ENTRYPOINT ["java","-jar","/worker-telegram.jar"]