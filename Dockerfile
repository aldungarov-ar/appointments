FROM eclipse-temurin:17-jdk
COPY target/appointments-0.0.1-SNAPSHOT.jar /appointments.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/appointments.jar"]