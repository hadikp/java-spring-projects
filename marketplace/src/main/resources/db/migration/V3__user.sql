create table users(id bigint auto_increment PRIMARY KEY, name varchar(50), user_name varchar(50), email varchar(50),
 password varchar(150), role bigint, registration_date date);
insert into users(name, user_name, email, password, role, registration_date) values ('Gergő', 'kissg', 'kissg@gmail.com', 'pass123', 1, '2022-12-12');
insert into users(name, user_name, email, password, role, registration_date) values ('Péter', 'hadikp', 'hadikp@gmail.com', 'p345', 2, '2022-12-15');