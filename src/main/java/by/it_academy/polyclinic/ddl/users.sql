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
    id integer NOT NULL DEFAULT nextval('polyclinic.users_id_seq'::regclass),
    first_name character varying COLLATE pg_catalog."default",
    surname character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    phone_number character varying COLLATE pg_catalog."default",
    med_card character varying COLLATE pg_catalog."default",
    health_status character varying COLLATE pg_catalog."default",
    user_role character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE polyclinic.users
    OWNER to postgres;


INSERT INTO polyclinic.users(
	first_name, surname, email, address, phone_number, med_card, health_status,user_role)
	VALUES
	('admin', 'admin', 'admin@admin.by', 'minsk', '+375291111111', '001', 'good','admin'),
	('AAA', 'BBB', 'aaa@aaan.by', 'minsk', '+375291122211', '002', 'good','user'),
	('CCC', 'CCC', 'aCCa@aaan.by', 'minsk', '+375291422211', '003', 'good','doctor')
	;

select * from polyclinic.users;

delete from polyclinic.users;
