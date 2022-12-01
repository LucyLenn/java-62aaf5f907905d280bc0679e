CREATE TABLE mainland
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

ALTER TABLE mainland ADD COLUMN existing BOOLEAN DEFAULT TRUE;

CREATE TABLE country
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    mainland_id INTEGER REFERENCES mainland (id) ON DELETE CASCADE
);

CREATE TABLE city
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL UNIQUE,
    population INTEGER,
    country_id INTEGER REFERENCES country (id) ON DELETE CASCADE
);

ALTER TABLE city ADD CONSTRAINT population CHECK (population >= 0);
