create table movies(id bigint auto_increment PRIMARY KEY, title varchar(50), date timestamp, free_spaces int, max_space int);
insert into movies(title, date, free_spaces, max_space) values ('Terminátor', now(), 111, 350);
insert into movies(title, date, free_spaces, max_space) values ('Ikrek', '2001-12-15', 122, 350);