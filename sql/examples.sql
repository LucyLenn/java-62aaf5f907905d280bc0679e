SELECT *
FROM mainland;

SELECT *
FROM country;

SELECT *
FROM city;

SELECT id, name, population
FROM city;

SELECT *
FROM city
WHERE country_id = 6;

SELECT city.*
FROM city AS city
         LEFT JOIN country ON city.country_id = country.id
WHERE country.name = 'Greece';

SELECT id, name, population
FROM city
WHERE population > 1000000;

UPDATE mainland
SET existing = FALSE
WHERE name = 'Pangea';

DELETE
FROM mainland
WHERE name = 'Pangea';
