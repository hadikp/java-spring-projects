create table runs(id bigint auto_increment PRIMARY KEY, type varchar(50), description varchar(150), km double,
 run_date date, training_id bigint);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'rövid futás', 10, '2025-01-01', 1);