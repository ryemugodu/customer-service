https://www.javainuse.com/devOps/docker/docker-mysql

Spring Boot 2.7.7
Swagger 2
MySql 8
Open JDK 17
Docker

Shell> docker network create persons-svc-network

Shell> docker container run --name mysql_docker_container --network persons-svc-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=personsdb -d mysql:8

Shell>  docker exec -it mysql_docker_container bash

bash-4.4# mysql -u root -p
Password: root
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'password1'

use personsdb; //connecting to database name space (https://linuxize.com/post/show-tables-in-mysql-database/)

create table person (id int(25) NOT NULL AUTO_INCREMENT, first_name varchar(255) NOT NULL, last_name varchar(255) NOT NULL, email varchar(255) NOT NULL, phone varchar(255) NOT NULL,  primary key(id));

insert into person (first_name, last_name, email, phone) values('raghu','yemugod', 'raghav.yengoti@gmail.com', '9502876651');

create table address(id int NOT NULL AUTO_INCREMENT, person_id INT NOT NULL, line1 varchar(255) NOT NULL, line2 varchar(255), postcode varchar(5), city varchar(255), state varchar(255), country varchar(255), PRIMARY KEY(id));

Alter table address add foreign key(person_id) references person(id);

insert into address(person_id, line1, line2, postcode, city, state,country) values(1, '435 Metro Pl S','', '43017','Dublin', 'Ohio', 'USA');


Create persons-svc spring boot application

create Dockerfile under project dir(persons-svc)
================================================
From openjdk:17
copy ./build/libs/persons-svc-0.0.1-SNAPSHOT.jar persons-svc-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","persons-svc-0.0.1-SNAPSHOT.jar"]

persons-svc> gradle clean build

build docker image
==================
C:\Users\yemugodr\eclipse-workspace\persons-svc>docker image build -t persons-svc .

Create docker container for persons-svc
==============================
docker container run --network persons-svc-network --name persons-svc-container -p 8080:8080 -d persons-svc

Note: If you are facing issue with access like “Access denied to user/database” then try below solution
mysql> CREATE USER 'root'@'localhost' IDENTIFIED BY 'password1';

mysql> CREATE USER 'root'@'172.19.0.3' IDENTIFIED BY 'password1';

mysql> GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';

mysql> GRANT ALL PRIVILEGES ON * . * TO 'root'@'172.19.0.3';

mysql> grant all privileges on personsdb.* to 'root'@'172.19.0.3';

mysql> grant all privileges on personsdb.* to 'root'@'localhost';

Swagger2 Configuration:
=======================
Swagger2 is compatable with Spring Boot 3.x so using Spring Boot 2.7.7 with Swagger2

**********End of working with docker manually**********

Using docker-compose: No need to do all the above manually and all you need is working with docker-compose.yml
=====================
1. Find the docker-compose.yml in the project root directory.
2. Navigate to project root

persons-svc>docker-compose build

persons-svc>docker-compose up -d

Swagger/OpenApi3 url
====================
http://localhost:8182/swagger-ui/index.html

