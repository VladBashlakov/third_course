

SELECT * FROM student WHERE name LIKE '12334%';
SELECT * FROM faculty WHERE color LIKE '%string';

CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_name_and_color ON faculty (name,color);

-- DROP INDEX student_name_index;
-- DROP INDEX faculty_name_and_color;