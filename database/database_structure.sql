create table users(
    id serial not null,
    name varchar(120) not null,
    username varchar(30) not null unique,
    password text not null,
    
    constraint users_pk primary key (id)
);

create table flags(
    id serial not null,
    company varchar(50) not null,
    
    constraint flags_pk primary key (id)
);
