create table bikes(id bigint auto_increment PRIMARY KEY, type varchar(50), description varchar(150), km double,
 bike_date date, training_id bigint);
insert into bikes(type, description, km, bike_date, training_id) values ('bicigli', 'biciglizés az Úrhidai telekre és vissza', 24, '2025-06-20', 242);