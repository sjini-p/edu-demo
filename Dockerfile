# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim

# Install required tools
RUN apt-get update && apt-get install -y \
    telnet \
    curl \
    procps \
    vim \
    jq \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar demo.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "demo.jar"]