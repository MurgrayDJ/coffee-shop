CREATE DATABASE coffee_shop;

USE coffee_shop;

CREATE TABLE IF NOT EXISTS coffee_types (
	type_id INT AUTO_INCREMENT,
    coffee_type VARCHAR(100) UNIQUE NOT NULL,
    has_coffee TINYINT NOT NULL,
    has_espresso TINYINT NOT NULL,
    milk_type TINYINT NOT NULL,
    has_other_ingredients TINYINT NOT NULL,
    PRIMARY KEY(type_id)
);

CREATE TABLE IF NOT EXISTS milk_types (
	milk_type_id INT AUTO_INCREMENT,
    milk_type VARCHAR(100) UNIQUE NOT NULL,
    milk_texture VARCHAR(100),
    PRIMARY KEY(milk_type_id)
);

ALTER TABLE coffee_types
RENAME TO hot_coffee_types;

ALTER TABLE hot_coffee_types
RENAME COLUMN milk_type TO milk_type_id;

ALTER TABLE hot_coffee_types
MODIFY COLUMN milk_type_id INT; 

ALTER TABLE hot_coffee_types 
ADD FOREIGN KEY (milk_type_id) REFERENCES milk_types(milk_type_id);