create table products(id bigint auto_increment PRIMARY KEY, product_name varchar(50), description varchar(150),
 product_type varchar(50), category varchar(50), active tinyint(1), image_path varchar(50), price int);
insert into products(product_name, description, product_type, category, active, image_path, price) values ('könyv', 'Ez egy könyv', 'BOOK', 'TRAVELING', true, 'src/images', 5110);
insert into products(product_name, description, product_type, category, active, image_path, price) values ('rádió', 'Ez egy rádió', 'RADIO', 'SALE', true, 'src/images', 5510);
insert into products(product_name, description, product_type, category, active, image_path, price) values ('Másik könyv', 'Ez a másik könyv', 'BOOK', 'GIFT', true, 'src/images', 0);
insert into products(product_name, description, product_type, category, active, image_path, price) values ('Másik rádió', 'Ez egy másik rádió', 'RADIO', 'GIFT', false, 'src/images', 0);
insert into products(product_name, description, product_type, category, active, image_path, price) values ('Harmadik könyv', 'Ez egy harmadik könyv', 'BOOK', 'SALE', true, 'src/images', 4100);