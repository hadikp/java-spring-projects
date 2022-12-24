create table comments(id bigint auto_increment PRIMARY KEY, content varchar(150), create_date date, product_id bigint, user_id bigint);
insert into comments(content, create_date, product_id, user_id) values ('comment1 content', "2022-12-01", 1, 1);
insert into comments(content, create_date, product_id, user_id) values ('comment2 content', "2022-12-02", 1, 1);
insert into comments(content, create_date, product_id, user_id) values ('comment3 content', "2022-12-03", 3, 2);