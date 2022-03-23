CREATE TABLE car
(
    car_id SERIAL UNIQUE ,
    value  INTEGER,
    mark   CHARACTER,
    model  CHARACTER

);

CREATE TABLE person
(
    id      SERIAL,
    name    TEXT PRIMARY KEY,
    age     INTEGER,
    license BOOLEAN,
    car_id  SERIAL REFERENCES car (car_id)
);
