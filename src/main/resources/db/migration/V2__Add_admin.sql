insert into "user" (id,login, password, email, nickname, active) values (1, 'Admin', 'Admin', 'Admin', 'Admin', true );
insert into user_role (user_id, roles) values (1, 'USER'), (1, 'ADMIN');