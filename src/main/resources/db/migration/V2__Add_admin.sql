insert into "user" (id,login, password, email, nickname, active) values (1, 'Admin', 'Admin', 'Admin', 'Admin', true );
insert into user_role (user_id, roles) values (1, 'USER'), (1, 'ADMIN');
-- create table user_sub(
    --   game_id int8 not null references game,
      -- user_id int8 not null references user,
      -- primary key (game_id, user_id)
   --);
   -- V3__Add_subscriptions_table.sql

