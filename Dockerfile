FROM adoptopenjdk:8-jre-hotspot
COPY target/ticket-app-0.0.1-SNAPSHOT.jar recipe.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/recipe.jar"]