FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar order-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","order-service.jar"]