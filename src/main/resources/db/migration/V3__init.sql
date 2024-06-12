CREATE VIEW view_character AS
SELECT
    c.id,
    c.description,
    c.cost,
    c.stock,
    s.description AS scene_name
FROM
    character c
        JOIN
    scene s ON c.scene_id = s.id;
