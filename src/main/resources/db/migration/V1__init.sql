CREATE TABLE IF NOT EXISTS film (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    duration INT,
    UNIQUE (title)
    );

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    budget DECIMAL(10, 2),
    minutes INT,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES film (id)
    );

CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    cost DECIMAL(10, 2),
    stock INT,
    scene_id INT,
    FOREIGN KEY (scene_id) REFERENCES scene (id)
    );
