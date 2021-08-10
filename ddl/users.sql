create table if not exists passports
(
    id                    bigint generated by default as identity
        constraint passports_pkey
            primary key,
    first_name            varchar(255),
    surname               varchar(255),
    address               varchar(255),
    birth_date            date,
    birth_place           varchar(255),
    date_of_issue         date,
    date_of_expiry        date,
    code_of_issuing_state varchar(255),
    nationality           varchar(255),
    passport_number       varchar(255),
    personal_no           varchar(255)
        constraint uk_qxig4rcgcpvvrgjv1ro6ry19p
            unique,
    sex                   varchar(255)
);

alter table passports
    owner to postgres;





create table if not exists medical_cards
(
    id            bigint generated by default as identity
        constraint medical_cards_pkey
            primary key,
    health_status integer
);

alter table medical_cards
    owner to postgres;

create table if not exists doctor
(
    id         bigint generated by default as identity
        constraint doctor_pkey
            primary key,
    department varchar(255),
    position   varchar(255),
    cabinet    varchar(3)
);

alter table doctor
    owner to postgres;


create table if not exists users
(
    id              bigint generated by default as identity
        constraint users_pkey
            primary key,
    username        varchar(255) not null
        constraint uk_r43af9ap4edm43mmtq01oddj6
            unique,
    password        varchar(255) not null,
    email           varchar(255)
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    phone_no        varchar(255)
        constraint uk_sixq0fu6tsxv2xt6l8nivm4wm
            unique,
    user_role       varchar(255) not null,
    passport_id     bigint
        constraint fk_user_passport_id
            references passports,
    medical_card_id bigint
        constraint fk_user_medical_card_id
            references medical_cards,
    doctor_id       bigint
        constraint fk_user_doctor_id
            references doctor
);

alter table users
    owner to postgres;

INSERT INTO medical_cards (health_status)
values (100),
       (90),
       (80),
       (80),
       (80),
       (80),
       (80),
       (80),
       (85);


INSERT INTO doctor (id, department, position, cabinet)
values (100, 'ХИРУРГИЯ', 'Хирург', '200'),
       (101, 'ПЕДИАТРИЯ', 'Педиатр', '201'),
       (102, 'ЛАБОРАТОРИЯ', 'Лаборант', '202'),
       (103, 'СТОМАТОЛОГИЯ', 'Стоматолог', '203'),
       (104, 'ТЕРАПИЯ', 'Терапевт', '204'),
       (106, 'РЕНТГЕНОЛОГИЯ', 'Рентгенолог', '206')
;

INSERT INTO public.passports (address, birth_date, birth_place, code_of_issuing_state, date_of_expiry, date_of_issue,
                              first_name, nationality, passport_number, personal_no, sex, surname)
VALUES ('г.Минск', '1992-01-01', 'г.Минск', '07', '2022-01-01', '2019-01-01', 'Admin', 'Беларус>', 'KH45a6789', '12343567', 'МУЖСКОЙ',
        'Adminov'),
       ('д.Ивановка', '1975-02-05', 'д.Ивановка', '06', '2022-01-01', '2019-01-01', 'Русский', 'Russia', 'KH4d56189', '1234156', 'ЖЕНСКИЙ',
        'Иванова'),
       ('г,Гомель', '1945-07-24', 'г,Гомель', '05', '2022-01-01', '2019-01-01', 'Док', 'Беларус', 'KH45f6189', '1523156', 'МУЖСКОЙ',
        'Докторов'),
       ('д.Гатово', '1990-02-01', 'г,Гомель', '04', '2022-01-01', '2019-01-01', 'Петр', 'Поляк', 'KH45g6189', '1236156', 'МУЖСКОЙ',
        'Петров'),
       ('пос.Речной', '2000-05-05', 'г.Минск', '03', '2022-01-01', '2019-01-01', 'Док', 'Беларус', 'KH456в189', '12в37156', 'ЖЕНСКИЙ',
        'Сидоров'),
       ('г,Гомель', '1947-07-24', 'г,Гродно', '02', '2022-01-01', '2019-01-01', 'Игорь', 'Беларус', 'KH15f6189', '1573156', 'МУЖСКОЙ',
        'Боричевский'),
       ('г,Гомель', '1975-07-24', 'г,Брест', '01', '2022-01-01', '2019-01-01', 'Иван', 'Беларус', 'KH25f6189', '152п156', 'МУЖСКОЙ',
        'Адамчук');


insert into users (username, password, email, phone_no, user_role, passport_id, medical_card_id)
values ('admin', '1', 'a@a', '+375291111111', 'ADMIN', 1, 1),
       ('maria', '1', 'm@m', '+375291111112', 'GUEST', 2, 2),
       ('petr', '1', 'p@p', '375291111113', 'PATIENT', 4, 4)
;
INSERT INTO users (username, password, email, phone_no, user_role, passport_id, medical_card_id, doctor_id)
values ('doc1', '1', 'd@d1', '+375291111114', 'DOCTOR', 3, 3, 100),
       ('doc2', '1', 'd@d2', '+375291111115', 'DOCTOR', 5, 5, 101),
       ('doc3', '1', 'd@d3', '+375291111116', 'DOCTOR', 6, 6, 102),
       ('doc4', '1', 'd@d4', '+375291111117', 'DOCTOR', 7, 7, 103);

--Кодируем сохранённые пароли. Новые пользователи будут поступать в базу уже закодированные
create extension if not exists pgcrypto;
update users
set password = crypt(password, gen_salt('bf', 8));


create table treatments
(
    id               bigint generated by default as identity
        constraint treatments_pkey
            primary key,
    recover_date     date,
    sick_date        date,
    disease_id       bigint
        constraint fk_treatment_disease_id
            references diseases,
    doctor_id        bigint
        constraint fks9o3g99apb0c9ho9ce02vx9hv
            references doctor,
    medical_cards_id bigint
        constraint fk9qo5n62p7sr0ivfckwsc35r21
            references medical_cards
);

alter table treatments
    owner to postgres;

INSERT INTO public.treatments (recover_date, sick_date, disease_id, doctor_id, medical_cards_id)
VALUES ('2021-08-18', '2021-08-09', 4, 101, 4);




