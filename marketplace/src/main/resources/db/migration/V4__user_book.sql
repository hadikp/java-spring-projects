create table user_book(id bigint auto_increment PRIMARY KEY, relation_type varchar(50), user_id bigint, book_id bigint);
insert into user_book(relation_type, user_id, book_id) values ('WISH', 1, 1);
insert into user_book(relation_type, user_id, book_id) values ('OFFERED', 1, 2);
insert into user_book(relation_type, user_id, book_id) values ('ACQUIRED', 2, 3);