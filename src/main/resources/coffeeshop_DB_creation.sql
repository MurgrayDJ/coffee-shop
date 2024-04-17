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
    has_coffee TINYINT NOT NULL,
    has_espresso TINYINT NOT NULL,
    milk_type_id INT,
    has_other_ingredients TINYINT NOT NULL,
    PRIMARY KEY(type_id),
    FOREIGN KEY (milk_type_id) REFERENCES milk_types(milk_type_id)
);


SHOW COLUMNS FROM hot_coffee_types;
SHOW COLUMNS FROM milk_types;
