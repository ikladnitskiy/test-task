SET client_encoding TO 'utf8';

DELETE FROM accounts;

INSERT INTO accounts (account_name, user_name, user_last_name)
VALUES ('Account123', 'UserName123', 'UserLastName123'),
       ('Account456', 'UserName456', 'UserLastName456'),
       ('Account789', 'UserName789', 'UserLastName789');