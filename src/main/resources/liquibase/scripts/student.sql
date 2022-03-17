-- liquibase formatted sql

-- changeset vbashlakov:1
SELECT * FROM student WHERE name LIKE '12334%';

-- changeset vvbashlakov:1
SELECT * FROM faculty WHERE color LIKE '%string'