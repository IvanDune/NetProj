create table public.game (
    id int8 not null,
    date_time timestamp,
    description varchar(2048),
    discord varchar(2048),
    name varchar(255),
    system varchar(255),
    primary key (id)
);
create table public.user (
    id int8 not null,
    active boolean,
    email varchar(255),
    login varchar(255) not null,
    nickname varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);

create sequence hibernate_sequence start 1 increment 1;

create table message (
    id int8 not null,
    num int4,
    text varchar(2048) not null,
    user_id int8,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

alter table if exists message
    add constraint message_user_fk
    foreign key (user_id) references public.user;
alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references public.user;
