ALTER TABLE student

    ADD CONSTRAINT age_constraint CHECK (age > 16),
    ALTER age SET DEFAULT 20,
    ALTER COLUMN name SET NOT NULL,
    ADD CONSTRAINT nickname_unique UNIQUE (name);

ALTER TABLE faculty
    ADD CONSTRAINT login_color UNIQUE (name, color);
