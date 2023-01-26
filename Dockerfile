From openjdk:17
copy ./build/libs/customer-svc-0.0.1-SNAPSHOT.jar customer-svc-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","customer-svc-0.0.1-SNAPSHOT.jar"]