FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:123456 -o DevOps_Project-2.1.jar "http://192.168.1.16:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar" -L
ENTRYPOINT ["java","-jar","/DevOps_Project-2.1.jar"]
EXPOSE 8089