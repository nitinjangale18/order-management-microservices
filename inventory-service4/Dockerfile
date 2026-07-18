FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar inventory-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","inventory-service.jar"]