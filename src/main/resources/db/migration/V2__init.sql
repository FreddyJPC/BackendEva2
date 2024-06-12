CREATE VIEW scene_with_film_name AS
SELECT
    s.id,
    s.description,
    s.budget,
    s.minutes,
    f.title AS film_name
FROM
    scene s
        JOIN
    film f ON s.film_id = f.id;
