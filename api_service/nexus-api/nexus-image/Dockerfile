FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY nexus-image/build/libs/nexus-image-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod}", "-jar", "app.jar"]
