SET client_encoding TO 'utf8';

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
    account_name   VARCHAR(128) NOT NULL
        CONSTRAINT accounts_pk
            PRIMARY KEY,
    user_name      VARCHAR(128),
    user_last_name VARCHAR(128)
);
