create table runs(id bigint auto_increment PRIMARY KEY, type varchar(50), description varchar(150), km double,
 run_date date, training_id bigint);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-04', 1);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-12', 2);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-18', 3);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-01-26', 4);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-02-01', 5);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-02-09', 6);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'hosszú futás', 50, '2025-02-15', 7);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'rövid futás', 15, '2025-02-23', 8);
insert into runs(type, description, km, run_date, training_id) values ('bicigli', 'rövid bicigli', 15, '2025-02-23', 9);
insert into runs(type, description, km, run_date, training_id) values ('futás', 'rövid futás', 15, '2025-03-01', 10);
insert into runs(type, description, km, run_date, training_id) values ('bicigli', 'rövid bicigli', 15, '2025-03-01', 11);
