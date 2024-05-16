CREATE SCHEMA IF NOT EXISTS coffee_shop;

CREATE TABLE IF NOT EXISTS milk_types (
    milk_type_id INT AUTO_INCREMENT PRIMARY KEY,
    milk_type VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS hot_coffee_types (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    coffee_type VARCHAR(100) UNIQUE NOT NULL,
    has_coffee BOOLEAN NOT NULL,
    has_espresso BOOLEAN NOT NULL,
    milk_type_id INT,
    milk_texture_id INT, 
    has_other_ingredients BOOLEAN NOT NULL,
    FOREIGN KEY (milk_type_id) REFERENCES milk_types(milk_type_id),
    FOREIGN KEY (milk_texture_id) REFERENCES milk_textures(texture_id)
);

CREATE TABLE IF NOT EXISTS milk_textures (
    texture_id INT AUTO_INCREMENT PRIMARY KEY,
    milk_texture VARCHAR(100) NOT NULL
);

INSERT INTO milk_textures(milk_texture)
VALUES 
('normal'),  
('steamed'),
('frothed'),
('foamed');

INSERT INTO milk_types (milk_type)
VALUES 
('no milk'),
('milk'),
('lactaid'),
('oat milk'),
('almond milk'),
('soy milk'),
('cream');

INSERT INTO hot_coffee_types
(coffee_type,
has_coffee,
has_espresso,
milk_type_id,
milk_texture_id,
has_other_ingredients)
VALUES
('black', TRUE, FALSE, 1, 1, FALSE),  
('latte', FALSE, TRUE, 2, 2, FALSE),
('cappucino', FALSE, TRUE, 2, 2, TRUE),
('americano', FALSE, TRUE, 1, 1, TRUE),
('espresso', FALSE, TRUE, 1, 1, FALSE),
('doppio', FALSE, TRUE, 1, 1, FALSE),
('cortado', FALSE, TRUE, 2, 2, FALSE),
('red eye', TRUE, TRUE, 1, 1, FALSE),
('galao', FALSE, TRUE, 2, 3, FALSE),
('lungo', FALSE, TRUE, 1, 1, FALSE),
('macchiato', FALSE, TRUE, 2, 3, FALSE),
('mocha', FALSE, TRUE, 2, 2, TRUE),
('ristretto', FALSE, TRUE, 1, 1, FALSE),
('flat white', FALSE, TRUE, 2, 2, FALSE),
('affogato', FALSE, TRUE, 1, 1, TRUE),
('cafe au lait', TRUE, FALSE, 2, 2, FALSE),
('irish', TRUE, FALSE, 7, 1, TRUE);