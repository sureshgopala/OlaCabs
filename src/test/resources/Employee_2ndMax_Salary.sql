-- create a table
CREATE TABLE students (
  id INTEGER PRIMARY KEY,
  name TEXT NOT NULL,
  gender TEXT NOT NULL,
  marks INTEGER NOT NULL
);
-- insert some values
INSERT INTO students VALUES (1, 'Ryan', 'M', 300);
INSERT INTO students VALUES (2, 'Joanna', 'F', 200);
INSERT INTO students VALUES (3, 'John', 'M', 100);
INSERT INTO students VALUES (4, 'Doe', 'F', 500);


-- fetch some values
SELECT min marks from students(SELECT Top(2) from students where marks );