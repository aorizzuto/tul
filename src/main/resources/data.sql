CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL,
    has_discount BIT(1) NOT NULL
);

-- http://localhost:8080/h2-console

--INSERT INTO products (id, name, sku, description, price, has_discount) VALUES
--('d7cd23b8991c470fac63d8fb106f391e', 'Remera', '1234567890', 'Remera manga corta', '100.65', true),
--('d7cd23b8991c470fac63d8fb106f391f', 'Pantalon', '1234567891', 'Pantalon largo', '2430.75', false),
--('d7cd23b8991c470fac63d8fb106f391g', 'Gorra', '1234567892', 'Gorra lisa', '1250.00', true),
--('d7cd23b8991c470fac63d8fb106f391h', 'Campera', '1234567893', 'Campera invierno', '30500', false),
--('d7cd23b8991c470fac63d8fb106f391i', 'Zapatillas', '1266567890', 'Zapatillas marca pepito', '4000.50', false),
--('d7cd23b8991c470fac63d8fb106f391j', 'Bufanda', '1234447894', 'Bufanda de lana', '2300', false),
--('d7cd23b8991c470fac63d8fb106f391k', 'Ojotas', '1234555890', 'Ojotas lisas', '980', true),
--('d7cd23b8991c470fac63d8fb106f391l', 'Medias Cortas', '1234577790', 'Medias cortas', '100', false),
--('d7cd23b8991c470fac63d8fb106f391m', 'Anteojos', '1888567890', 'Anteojos de sol', '200.3', false),
--('d7cd23b8991c470fac63d8fb106f391n', 'Pulseras', '1234599990', 'Pulsera', '3', true);