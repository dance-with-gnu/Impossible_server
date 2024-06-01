# Start with a Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Start a new stage from a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /mnt/sdb/code/impossible

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Set the timezone
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezone

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"]
