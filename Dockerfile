# Use a base image with Java installed
FROM openjdk:11-jre-slim

EXPOSE 8089

WORKDIR /app

# Install curl in the container
RUN apt-get update && apt-get install -y curl


ENTRYPOINT ["java", "-jar", "executable-1.0.jar"]
