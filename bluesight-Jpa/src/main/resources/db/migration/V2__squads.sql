create table squads(id bigint auto_increment PRIMARY KEY, name varchar(50), description varchar(150), start_date date, board_id bigint);
insert into squads(name, description, start_date, board_id) values ('squad1', 'Description of squad1', '2022-12-12', 1);
insert into squads(name, description, start_date, board_id) values ('squad2', 'Description of squad2', '2022-12-14', 2);
insert into squads(name, description, start_date, board_id) values ('squad3', 'Description of squad3', '2022-12-15', 3);