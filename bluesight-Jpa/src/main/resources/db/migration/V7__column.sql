create table columns(id bigint auto_increment PRIMARY KEY, name varchar(50), position_number int, card_count int, wip_limit int, swimlane_id bigint);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Column1', 1, 5, 111, 1);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Column2', 2, 5, 111, 1);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Column3', 1, 5, 111, 2);