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

create table card_type(
    id serial not null,
    type varchar(30) not null,
    
    constraint card_type_pk primary key (id)
);

create table card(
    id serial not null,
    payment_day int not null,
    closing_invoice_day int,
    expiration_date date not null,
    id_flag int not null,
    id_card_type int not null,
    id_user int not null,
    
    constraint card_pk primary key (id),
    constraint card_flag_fk foreign key (id_flag) references flags (id),
    constraint card_card_type_fk foreign key (id_card_type) references card_type (id),
    constraint card_user_fk foreign key (id_user) references users (id)
);

create table category(
    id serial not null,
    name varchar(200) not null,
    id_sub_category int,
    
    constraint category_pk primary key (id),
    constraint category_sub_category_fk foreign key (id_sub_category) references category (id)
);

create table payment_method(
    id serial not null,
    name varchar(50) not null,
    
    constraint payment_method_pk primary key (id)
);

create table costs(
    id serial not null,
    description varchar(200) not null,
    value float not null,
    number_of_parcels int,
    payment_date DATE default CURRENT_DATE,
    id_category int,
    id_payment_method int,
    
    constraint costs_method_pk primary key (id),
    constraint costs_category_fk foreign key (id_category) references category(id),
    constraint costs_payment_method_fk foreign key (id_payment_method) references payment_method(id)
    
);

create table receipt(
    id serial not null,
    description varchar(200) not null,
    value float not null,
    receipt_date DATE not null default CURRENT_DATE,
    id_category int,
    
    constraint receipt_pk primary key (id),
    constraint receipt_category_fk foreign key (id_category) references category(id)
);

create table agenda(
    id serial not null,
    id_costs int,
    id_receipt int,
    is_paied boolean,
    
    constraint agenda_pk primary key (id),
    constraint agenda_costs_fk foreign key (id_costs) references costs(id),
    constraint agenda_receipt_fk foreign key (id_receipt) references receipt(id)

);

