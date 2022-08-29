create table users(id bigint auto_increment PRIMARY KEY, user_name varchar(50), email varchar(150), password varchar(150),
 registration_date date);
insert into users(user_name, email, password, registration_date) values ('Péter', 'hadikp@gmail.com', 'pass123', '2022-01-05');