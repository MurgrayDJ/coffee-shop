ALTER TABLE milk_types
DROP COLUMN milk_texture;

INSERT INTO milk_types(milk_type_id, milk_type)
VALUES 
(DEFAULT, 'no milk'),
(DEFAULT, 'milk'),
(DEFAULT, 'lactaid'),
(DEFAULT, 'oat milk'),
(DEFAULT, 'almond milk'),
(DEFAULT, 'soy milk');

CREATE TABLE IF NOT EXISTS coffee_types (
	type_id INT AUTO_INCREMENT,
    coffee_type VARCHAR(100) UNIQUE NOT NULL,
    has_coffee TINYINT NOT NULL,
    has_espresso TINYINT NOT NULL,
    milk_type_id INT NOT NULL,
    milk_texture TINYINT, 
    has_other_ingredients TINYINT NOT NULL,
    PRIMARY KEY(type_id),
    FOREIGN KEY(milk_type_id) REFERENCES milk_types(milk_type_id)
);

DROP TABLE hot_coffee_types;

ALTER TABLE coffee_types
RENAME TO hot_coffee_types;

CREATE TABLE IF NOT EXISTS milk_textures (
	texture_id INT AUTO_INCREMENT,
    milk_texture VARCHAR(100) NOT NULL,
    PRIMARY KEY(texture_id)
);

INSERT INTO milk_textures(texture_id, milk_texture)
VALUES 
(DEFAULT, "steamed"),
(DEFAULT, "frothed"),
(DEFAULT, "foamed");

ALTER TABLE hot_coffee_types
ALTER milk_type_id SET DEFAULT 1;

ALTER TABLE hot_coffee_types
ALTER milk_type_id SET DEFAULT 2;

INSERT INTO milk_types
VALUES (DEFAULT, "cream");


INSERT INTO hot_coffee_types
(type_id,
coffee_type,
has_coffee,
has_espresso,
milk_type_id,
milk_texture,
has_other_ingredients)
VALUES
(DEFAULT, 'black', 1, 0, 1, NULL, 0),
(DEFAULT, 'latte', 0, 1, DEFAULT, 1, 0),
(DEFAULT, 'cappucino', 0, 1, DEFAULT, 1, 1),
(DEFAULT, 'americano', 0, 1, 1, NULL, 1),
(DEFAULT, 'espresso', 0, 1, 1, NULL, 0),
(DEFAULT, 'doppio', 0, 1, 1, NULL, 0),
(DEFAULT, 'cortado', 0, 1, DEFAULT, 1, 0),
(DEFAULT, 'red eye', 1, 1, 1, NULL, 0),
(DEFAULT, 'galao', 0, 1, DEFAULT, 3, 0),
(DEFAULT, 'lungo', 0, 1, 1, NULL, 0),
(DEFAULT, 'macchiato', 0, 1, DEFAULT, 3, 0),
(DEFAULT, 'mocha', 0, 1, DEFAULT, 1, 1),
(DEFAULT, 'ristretto', 0, 1, 1, NULL, 0),
(DEFAULT, 'flat white', 0, 1, DEFAULT, 1, 0),
(DEFAULT, 'affogato', 0, 1, 1, NULL, 1),
(DEFAULT, 'cafe au lait', 1, 0, DEFAULT, 1, 0),
(DEFAULT, 'irish', 1, 0, 7, NULL, 1);

CREATE VIEW hot_coffees_with_milk_types AS 
SELECT type_id, coffee_type, milk_types.milk_type AS milk_type  
FROM hot_coffee_types, milk_types 
WHERE hot_coffee_types.milk_type_id = milk_types.milk_type_id;




