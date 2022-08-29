create table entries(id bigint auto_increment PRIMARY KEY, title varchar(150), description varchar(250), content varchar(50),
 create_time timestamp, user_id bigint);
insert into entries(title, description, content, create_time, user_id) values ('First post', 'Description of first post',
                'Body of first post', '2022-01-11', 1);