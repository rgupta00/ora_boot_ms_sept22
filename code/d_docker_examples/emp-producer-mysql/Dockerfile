FROM openjdk:8
EXPOSE 8081
ADD target/emp-mysql.jar emp-mysql.jar
ENTRYPOINT ["java","-jar","emp-mysql.jar"]