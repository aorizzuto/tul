CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL,
    has_discount BIT(1) NOT NULL
);

-- http://localhost:8080/h2-console

CREATE TABLE IF NOT EXISTS orders (
    id VARCHAR(255) PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL,
    quantity INT(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts (
    id VARCHAR(255) PRIMARY KEY,
    orders VARCHAR(255) NULL,
    status VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS CARTS_ORDERS (
    cart_id VARCHAR(255),
    orders_id VARCHAR(255)
);