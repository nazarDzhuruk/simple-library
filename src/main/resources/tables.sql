CREATE TABLE IF NOT EXISTS reader
(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    surname VARCHAR
);

CREATE TABLE IF NOT EXISTS book
(
    id SERIAL PRIMARY KEY,
    title VARCHAR,
    author VARCHAR,
    publisher VARCHAR,
    user_id SERIAL,
    FOREIGN KEY (user_id) REFERENCES reader (id) ON DELETE CASCADE
);