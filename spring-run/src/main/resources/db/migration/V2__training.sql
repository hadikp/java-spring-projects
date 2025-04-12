create table trainings(id bigint auto_increment PRIMARY KEY, type varchar(50), sum_month_km double, sum_year_km double,
 training_date date);
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 50, 50, '2025-01-04');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 100, 100, '2025-01-12');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 150, 150, '2025-01-18');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 200, 200, '2025-01-26');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 50, 250, '2025-02-01');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 100, 300, '2025-02-09');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 150, 350, '2025-02-15');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 165, 365, '2025-02-23');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('bicigli', 15, 15, '2025-02-23');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('futás', 15, 380, '2025-03-01');
insert into trainings(type, sum_month_km, sum_year_km, training_date) values ('bicigli', 15, 30, '2025-03-01');
