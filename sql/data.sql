INSERT INTO Mainland (name)
VALUES ('Eurasia'),
       ('North America'),
       ('South America'),
       ('Africa'),
       ('Australia'),
       ('Antarctica');
INSERT INTO mainland (name)
VALUES ('Pangea');

INSERT INTO country (name, mainland_id)
VALUES ('Austria', 1),
       ('Argentina', 3),
       ('Bangladesh', 1),
       ('Brazil', 3),
       ('Guinea', 4),
       ('Greece', 1),
       ('Denmark', 1),
       ('Canada', 2),
       ('Colombia', 3),
       ('USA', 2);

INSERT INTO city (name, population, country_id)
VALUES ('Vienna', 1931593, 1),
       ('Wels', null, 1),
       ('Santa Fe', 391164, 2),
       ('Volos', 86046, 6),
       ('Peristeri ', 139981, 6),
       ('Galatsi', 59345, 6);

INSERT INTO country (name, mainland_id)
VALUES ('PangeaCountry1', 7);

INSERT INTO city (name, population, country_id)
VALUES ('PangeaCity1', 1, 11);
