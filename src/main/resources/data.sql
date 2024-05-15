CREATE DATABASE coffee_shop;

USE coffee_shop;

CREATE TABLE IF NOT EXISTS milk_types (
    milk_type_id INT AUTO_INCREMENT,
    milk_type VARCHAR(100) UNIQUE NOT NULL,
    milk_texture VARCHAR(100),
    PRIMARY KEY(milk_type_id)
);

CREATE TABLE IF NOT EXISTS hot_coffee_types (
    type_id INT AUTO_INCREMENT,
    coffee_type VARCHAR(100) UNIQUE NOT NULL,
    has_coffee BOOLEAN NOT NULL,
    has_espresso BOOLEAN NOT NULL,
    milk_type_id INT,
    milk_texture INT, 
    has_other_ingredients BOOLEAN NOT NULL,
    PRIMARY KEY(type_id),
    FOREIGN KEY (milk_type_id) REFERENCES milk_types(milk_type_id)
);

CREATE TABLE IF NOT EXISTS milk_textures (
    texture_id INT AUTO_INCREMENT PRIMARY KEY,
    milk_texture VARCHAR(100) NOT NULL
);

INSERT INTO milk_types (milk_type, milk_texture)
VALUES 
('no milk', NULL),
('milk', NULL),
('lactaid', NULL),
('oat milk', NULL),
('almond milk', NULL),
('soy milk', NULL),
('cream', NULL);

INSERT INTO milk_textures(milk_texture)
VALUES 
('steamed'),
('frothed'),
('foamed');

INSERT INTO hot_coffee_types
(coffee_type,
has_coffee,
has_espresso,
milk_type_id,
milk_texture,
has_other_ingredients)
VALUES
('black', TRUE, FALSE, 1, NULL, FALSE),
('latte', FALSE, TRUE, 2, 1, FALSE),
('cappucino', FALSE, TRUE, 2, 1, TRUE),
('americano', FALSE, TRUE, 1, NULL, TRUE),
('espresso', FALSE, TRUE, 1, NULL, FALSE),
('doppio', FALSE, TRUE, 1, NULL, FALSE),
('cortado', FALSE, TRUE, 2, 1, FALSE),
('red eye', TRUE, TRUE, 1, NULL, FALSE),
('galao', FALSE, TRUE, 2, 3, FALSE),
('lungo', FALSE, TRUE, 1, NULL, FALSE),
('macchiato', FALSE, TRUE, 2, 3, FALSE),
('mocha', FALSE, TRUE, 2, 1, TRUE),
('ristretto', FALSE, TRUE, 1, NULL, FALSE),
('flat white', FALSE, TRUE, 2, 1, FALSE),
('affogato', FALSE, TRUE, 1, NULL, TRUE),
('cafe au lait', TRUE, FALSE, 2, 1, FALSE),
('irish', TRUE, FALSE, 7, NULL, TRUE);