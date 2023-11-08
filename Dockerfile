FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:admin -o kaddem.jar "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/kaddem-1.0.jar" -L
ENTRYPOINT ["java","-jar","/kaddem.jar"]
EXPOSE 8089