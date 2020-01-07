FROM openjdk:11-jre-slim
COPY build/libs/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]