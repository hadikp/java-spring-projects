create table users(id bigint auto_increment PRIMARY KEY, name varchar(50), user_name varchar(50), email varchar(50),
 password varchar(50), photo varchar(50), country varchar(50), admin tinyint(1), registration_date date);
insert into users(name, user_name, email, password, photo, country, admin, registration_date)
  values ('Péter', 'hadikp', 'hadikp@gmail.com', 'pass123', "src/images", 'Hungary', true, '2022-12-01');
insert into users(name, user_name, email, password, photo, country, admin, registration_date)
 values ('Gergő', 'tothg', 'tothg@gmail.com', 'pass234', "src/images", 'Hungary', false, '2022-12-02');