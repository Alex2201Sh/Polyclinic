-- Database: polyclinic

-- DROP DATABASE polyclinic;

CREATE DATABASE polyclinic
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- SCHEMA: polyclinic

-- DROP SCHEMA polyclinic ;

CREATE SCHEMA polyclinic
    AUTHORIZATION postgres;


-- Table: polyclinic.users

-- DROP TABLE polyclinic.users;

CREATE TABLE polyclinic.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    first_name character varying COLLATE pg_catalog."default",
    surname character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    phone_number character varying COLLATE pg_catalog."default",
    med_card integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    health_status character varying COLLATE pg_catalog."default",
    user_role character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE polyclinic.users
    OWNER to postgres;


INSERT INTO polyclinic.users(
	first_name, surname, email, address, phone_number, health_status, user_role)
	VALUES
	('admin', 'admin', 'admin@admin.by', 'minsk', '+375291234567', '10', 'ROLE_SUPERADMIN'),
	('Ivan', 'Ivanov', 'Ivanov@Ivanov.by', 'minsk', '+375292224567', '10', 'ROLE_USER'),
	('Petr', 'Petrov', 'Petrov@Petrov.by', 'minsk', '+3752933334567', '10', 'ROLE_DOCTOR'),
	('Anton', 'Antonov', 'Antonov@Antonov.by', 'minsk', '+375297774567', '10', 'ROLE_USER'),
	('Vasili', 'Sidorov', 'Sidorov@Sidorov.by', 'minsk', '+375291111567', '10', 'ROLE_USER'),
	('Pavel', 'Sobolev', 'Sobolev@Sobolev.by', 'minsk', '+375291589367', '10', 'ROLE_USER');

select * from polyclinic.users;

delete from polyclinic.users;
