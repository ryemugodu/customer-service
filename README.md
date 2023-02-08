https://www.javainuse.com/devOps/docker/docker-mysql

Spring Boot 2.7.7
Swagger 2
MySql 8
Open JDK 17
Docker

Shell> docker network create customer-svc-network

Shell> docker container run --name mysql_docker_container --network customer-svc-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customerdb -d mysql:8

Shell>  docker exec -it mysql_docker_container bash

bash-4.4# mysql -u root -p
Password: root
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'password1'

Refer mysqldb-dump/schema-mysql.sql for customerdb database.

Create customer-svc spring boot application

create Dockerfile under project dir(customer-svc)
================================================
From openjdk:17
copy ./build/libs/customer-svc-0.0.1-SNAPSHOT.jar customer-svc-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","customer-svc-0.0.1-SNAPSHOT.jar"]

customer-svc> gradle clean build

build docker image
==================
C:\eclipse-workspace\customer-svc>docker image build -t customer-svc .

Create docker container for customer-svc
==============================
docker container run --network customer-svc-network --name customer-svc-container -p 8080:8080 -d customer-svc

Note: If you are facing issue with access like “Access denied to user/database” then try below solution
mysql> CREATE USER 'root'@'localhost' IDENTIFIED BY 'password1';

mysql> CREATE USER 'root'@'172.19.0.3' IDENTIFIED BY 'password1';

mysql> GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';

mysql> GRANT ALL PRIVILEGES ON * . * TO 'root'@'172.19.0.3';

mysql> grant all privileges on customerdb.* to 'root'@'172.19.0.3';

mysql> grant all privileges on customerdb.* to 'root'@'localhost';

Swagger2 Configuration:
=======================
Swagger2 is compatable with Spring Boot 3.x so using Spring Boot 2.7.7 with Swagger2

**********End of working with docker manually**********

Using docker-compose: No need to do all the above manually and all you need is working with docker-compose.yml
=====================
1. Find the docker-compose.yml in the project root directory.
2. Navigate to project root

C:\eclipse-workspace\customer-svc>gradle clean build
C:\eclipse-workspace\customer-svc>docker image build -t customer-svc-jpa .
C:\eclipse-workspace\customer-svc>docker-compose build
C:\eclipse-workspace\customer-svc>docker-compose down
C:\eclipse-workspace\customer-svc>docker-compose up -d

Swagger/OpenApi3 url
====================
http://localhost:8182/swagger-ui/index.html

