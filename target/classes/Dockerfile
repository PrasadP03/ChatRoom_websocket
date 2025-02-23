# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file and source code into the container
COPY target/ChatRoomWithoutDatabase-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application is running on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
