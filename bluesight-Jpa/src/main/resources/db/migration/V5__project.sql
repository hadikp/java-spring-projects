create table projects(id bigint auto_increment PRIMARY KEY, name varchar(50), status varchar(50), description varchar(150),
 closed_at date, due_date date, squad_id bigint, user_id bigint);
insert into projects(name, status, description, closed_at, due_date, squad_id, user_id) values ('Project1', 'ready to work', 'Description of project1', '2022-12-11', '2023-01-15', 1, 1);
insert into projects(name, status, description, closed_at, due_date, squad_id, user_id) values ('Project2', 'ready to work', 'Description of project2', '2022-12-12', '2023-01-15', 1, 1);
insert into projects(name, status, description, closed_at, due_date, squad_id, user_id) values ('Project3', 'ready to work', 'Description of project3', '2022-12-13', '2023-01-15', 2, 2);
insert into projects(name, status, description, closed_at, due_date, squad_id, user_id) values ('Project4', 'ready to work', 'Description of project4', '2022-12-14', '2023-01-15', 3, 2);