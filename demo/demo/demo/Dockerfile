# Use an official OpenJDK 11 JDK as a parent image
FROM openjdk:11-jdk-slim

# Set environment variables
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk
ENV PATH $JAVA_HOME/bin:$PATH

# Set the working directory inside the container
WORKDIR /app

# Copy the source code of the application into the container
COPY src /app/src

# Copy the Models folder into the container
COPY Models /app/Models

# Copy jarfile_lib directory into the container
COPY jarfile_lib /app/jarfile_lib

# Copy the compiled JAR file from the target directory into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Copy JUnit JAR file into the container
COPY src/main/java/com/example/demo/junit/junit-4.13.2.jar /org/junit-4.13.2.jar
COPY jarfile.jar /app/jarfile.jar
# Set the CLASSPATH environment variable to include junit JAR
ENV CLASSPATH=/org/junit-4.13.2.jar:$CLASSPATH

# Ensure javac is available
RUN javac -version

# Expose port 8080
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
