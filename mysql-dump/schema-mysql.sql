CREATE DATABASE customerdb;
use customerdb;
create table IF NOT EXISTS customer (id int(25) NOT NULL AUTO_INCREMENT, first_name varchar(255) NOT NULL, last_name varchar(255) NOT NULL, email varchar(255) NOT NULL, phone varchar(255) NOT NULL,  primary key(id));

insert into customer (first_name, last_name, email, phone) values('raghu','yemugodu', 'rryemugodu@gmail.com', '9502876653');
insert into customer (first_name, last_name, email, phone) values('raghav','yemugodu', 'ryemugodu@gmail.com', '9502876652');

create table address(id int NOT NULL AUTO_INCREMENT, customer_id INT NOT NULL, line1 varchar(255) NOT NULL, line2 varchar(255), postcode varchar(5), city varchar(255), state varchar(255), country varchar(255), PRIMARY KEY(id));

Alter table address add foreign key(customer_id) references customer(id);

insert into address(customer_id, line1, line2, postcode, city, state,country) values(1, '435 Metro Pl S','', '43017','Dublin', 'Ohio', 'USA');

commit;