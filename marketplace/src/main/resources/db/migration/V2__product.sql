create table products(id bigint auto_increment PRIMARY KEY, name varchar(50), description varchar(150), product_type varchar(50), image_path varchar(50), price int);
insert into products(name, description, product_type, image_path, price) values ('könyv', 'Ez egy könyv', 'BOOK', 'src/images', 510);
insert into products(name, description, product_type, image_path, price) values ('rádió', 'Ez egy rádió', 'RADIO', 'src/images', 5510);
insert into products(name, description, product_type, image_path, price) values ('Másik könyv', 'Ez a másik könyv', 'BOOK', 'src/images', 5500);