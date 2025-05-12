create table messages(id bigint auto_increment PRIMARY KEY, email varchar(50), message varchar(250), user_id bigint);
insert into messages(email, message, user_id) values ('fg@gmail.com', 'message1 content', 1);
insert into messages(email, message, user_id) values ('tp@gmail.com', 'message2 content', 2);
insert into messages(email, message, user_id) values ('hg@gmail.com', 'message3 content', 2);