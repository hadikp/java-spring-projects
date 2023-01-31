create table messages(id bigint auto_increment PRIMARY KEY, subject varchar(50), content varchar(250), create_date date,  user_id bigint);
insert into messages(subject, content, create_date, user_id) values ('message1 subject', 'message1 content', "2022-12-01", 1);
insert into messages(subject, content, create_date, user_id) values ('message2 subject', 'message2 content', "2022-12-11", 2);
insert into messages(subject, content, create_date, user_id) values ('message3 subject', 'message3 content', "2022-12-12", 2);