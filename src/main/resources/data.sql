CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NULL,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL,
    has_discount BIT(1) NOT NULL
);

-- http://localhost:8080/h2-console

INSERT INTO products (name, sku, description, price, has_discount) VALUES
('Remera', '1234567890', 'Remera manga corta', '100.65', true),
('Pantalon', '1234567891', 'Pantalon largo', '2430.75', false),
('Gorra', '1234567892', 'Gorra lisa', '1250.00', true),
('Campera', '1234567893', 'Campera invierno', '30500', false),
('Bufanda', '1234447894', 'Bufanda de lana', '2300', false),
('Ojotas', '1234555890', 'Ojotas lisas', '980', true),
('Zapatillas', '1266567890', 'Zapatillas marca pepito', '4000.50', false),
('Medias Cortas', '1234577790', 'Medias cortas', '100', false),
('Anteojos', '1888567890', 'Anteojos de sol', '200.3', false),
('Pulseras', '1234599990', 'Pulsera', '3', true);