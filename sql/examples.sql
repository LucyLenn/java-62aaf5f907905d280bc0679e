-- Получение в одном запросе всех городов и стран к которым они относят
SELECT city.name, country.name
FROM city
         JOIN country ON city.country_id = country.id;

-- Получение общего числа населения для конкретного города
SELECT name, population
FROM city
WHERE name = 'Volos';

-- Получение общего числа населения для конкретной страны
SELECT sum(city.population), country.name
FROM city
         JOIN country ON city.country_id = country.id
WHERE country.name = 'Greece'
GROUP BY country.name;

-- Получение в одном запросе среднего количества населения для каждой из стран
SELECT avg(city.population), country.name
FROM city
         JOIN country ON city.country_id = country.id
GROUP BY country.name;

-- Обновление значения населения конкретного города (с применением транзакции)
-- действие одно, можно было бы обойтись без явного указания транзакции
BEGIN;
UPDATE city
SET population = 111111
WHERE name = 'Volos';
COMMIT;

-- Удаление в одном запросе нескольких городов (с применением транзакции)
-- действие одно, можно было бы обойтись без явного указания транзакции
BEGIN;
DELETE
FROM city
WHERE name = 'Galatsi'
   OR name = 'Wels';
COMMIT;

-- Получение в одном запросе количества городов для каждой из стран
SELECT count(city.id), country.name
FROM city
         JOIN country ON city.country_id = country.id
GROUP BY country.name;
