-- liquibase formatted sql

-- changeset vbashlakov:1
SELECT * FROM student WHERE name LIKE '12334%';


-- changeset vvbashlakov:1
SELECT * FROM faculty WHERE color LIKE '%string';

-- changeset vvvbashlakov:1
CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_name_and_color ON faculty (name,color);

