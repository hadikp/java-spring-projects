create table trainings(id bigint auto_increment PRIMARY KEY, type varchar(50), sum_month_km double, sum_year_km double,
 training_date date);
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 110, 210, '2025-01-30');