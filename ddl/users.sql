create table if not exists diseases
(
    id          bigint not null
        constraint diseases_pkey
            primary key,
    description varchar(255),
    name        varchar(255)
);

alter table diseases
    owner to postgres;

create table if not exists medical_cards
(
    id            bigint not null
        constraint medical_cards_pkey
            primary key,
    disease_id    varchar(255),
    health_status varchar(255),
    recover_date  timestamp,
    sick_date     timestamp
);

alter table medical_cards
    owner to postgres;

create table if not exists passports
(
    id                    varchar(255) not null
        constraint passports_pkey
            primary key,
    address               varchar(255),
    birth_date            varchar(255),
    birth_place           varchar(255),
    code_of_issuing_state varchar(255),
    date_of_expiry        varchar(255),
    date_of_issue         varchar(255),
    first_name            varchar(255),
    nationality           varchar(255),
    passport_number       varchar(255),
    sex                   varchar(255),
    surname               varchar(255)
);

alter table passports
    owner to postgres;

create table if not exists users
(
    id              bigint not null
        constraint users_pkey
            primary key,
    email           varchar(255),
    medical_card_id varchar(255),
    passport_id     varchar(255),
    password        varchar(255),
    phone_number    varchar(255),
    username        varchar(255)
);

alter table users
    owner to postgres;

create table if not exists user_role
(
    user_id bigint not null
        constraint fkj345gk1bovqvfame88rcx7yyx
            references users,
    roles   varchar(255)
);

alter table user_role
    owner to postgres;



INSERT INTO public.users(id, email, medical_card_id, passport_id, password, phone_number, username)
VALUES (2, 'alex@yandex.com', '', '', 1, '', 'Alex'),
       (3, 'petr@gmail.com', '', '', 1, '', 'Petr'),
       (1, 'admin@admin.com', '', '', 1, '+375291111111', 'admin'),
       (4, 'maria@mail.ru', '', '', 1, '+3751111111', 'Maria');

INSERT INTO public.user_role(user_id, roles)
VALUES (1, 'ADMIN'),
       (2, 'PATIENT'),
       (3, 'DOCTOR'),
       (4, 'GUEST');
