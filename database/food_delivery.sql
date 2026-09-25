// Create the Database
CREATE DATABASE food_delivery;

USE food_delivery;

// Create menu_items
CREATE TABLE menu_items (
    item_id INT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE,
    is_available BOOLEAN
);

//Add some sample items:
INSERT INTO menu_items
(item_id, name, price, is_available)
VALUES
(101, 'Pizza', 299.00, TRUE),
(102, 'Burger', 149.00, TRUE),
(103, 'Pasta', 199.00, TRUE),
(104, 'Biryani', 249.00, FALSE);

// Create customers
CREATE TABLE customers (
    customer_id VARCHAR(50) PRIMARY KEY,
    wallet_balance DOUBLE
);

//Add a customer:
INSERT INTO customers
(customer_id, wallet_balance)
VALUES
('C101', 5000.00);

//Create restaurants
CREATE TABLE restaurants (
    restaurant_id INT PRIMARY KEY,
    restaurant_name VARCHAR(100),
    pending_orders INT
);

//Add some restaurants:
INSERT INTO restaurants
(restaurant_id, restaurant_name, pending_orders)
VALUES
(1, 'Food Palace', 0),
(2, 'Spice Hub', 0),
(3, 'Burger Point', 0);

//Create orders
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id VARCHAR(50),
    restaurant_id INT,
    amount DOUBLE,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

//Check All Tables
SHOW TABLES;

//Our Database Structure
-- food_delivery
-- │
-- ├── menu_items
-- │     ├── item_id
-- │     ├── name
-- │     ├── price
-- │     └── is_available
-- │
-- ├── customers
-- │     ├── customer_id
-- │     └── wallet_balance
-- │
-- ├── restaurants
-- │     ├── restaurant_id
-- │     ├── restaurant_name
-- │     └── pending_orders
-- │
-- └── orders
--       ├── order_id
--       ├── customer_id
--       ├── restaurant_id
--       ├── amount
--       └── order_date
