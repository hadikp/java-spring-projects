create table runs(id bigint auto_increment PRIMARY KEY, type varchar(50), description varchar(150), km double,
 run_date date, training_id bigint);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-04', 1);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-12', 2);
