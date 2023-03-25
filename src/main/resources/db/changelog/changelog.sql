
-- liquibase formatted sql

-- changeset liquibase:3
INSERT INTO product(name, sku_code, unit_price) VALUES ('Glue', 'S1', 20.0);

-- changeset liquibase:4
INSERT INTO product(name, sku_code, unit_price) VALUES ('Piston', 'P1', 50.0);