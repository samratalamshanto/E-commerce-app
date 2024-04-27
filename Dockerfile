FROM openjdk:21
EXPOSE 9090
ADD target/demo_e-commerce_app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]