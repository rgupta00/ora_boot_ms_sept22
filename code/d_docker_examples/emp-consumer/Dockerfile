FROM openjdk:8
EXPOSE 8081
ADD target/emp-consumer.jar emp-consumer.jar
ENTRYPOINT ["java","-jar","emp-consumer.jar"]