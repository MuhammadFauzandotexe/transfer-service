FROM openjdk:17-alpine3.14
COPY build/libs/*.jar testapp.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","testapp.jar"]