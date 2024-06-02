# Use Gradle to build the application
FROM gradle:7.2.0-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle files and download dependencies
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
RUN gradle build --no-daemon

# Copy the source code and build the application
COPY src ./src
RUN gradle build --no-daemon

# Use a slim Java image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /mnt/sdb/code/impossible

# Copy the built JAR file from the previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Set the timezone
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezone

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"]
