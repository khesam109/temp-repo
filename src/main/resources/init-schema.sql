DROP SCHEMA IF EXISTS "account" CASCADE;
CREATE SCHEMA "account";

DROP TABLE IF EXISTS "account".accounts CASCADE;
CREATE TABLE "account".accounts
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    balance integer NOT NULL,
    account_status character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);


