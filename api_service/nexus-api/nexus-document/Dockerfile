FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY nexus-document/build/libs/nexus-document-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod}", "-jar", "app.jar"]
