# Use a base Java image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/my-app.jar /app/my-app.jar

# Set the entry point command to run the application
CMD ["java", "-jar", "makemytrip.jar"]
