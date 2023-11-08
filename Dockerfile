# Use a base image with Java installed
FROM openjdk:11-jre-slim

EXPOSE 8089

WORKDIR /app

# Install curl in the container
RUN apt-get update && apt-get install -y curl

# Download the JAR file from the Nexus repository and name it kaddam-1.0.jar
RUN curl -o executable-1.0.jar -L http://192.168.33.10:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar

ENTRYPOINT ["java", "-jar", "executable-1.0.jar"]