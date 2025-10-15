CREATE TABLE product_category (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  category_name VARCHAR(255)
);

INSERT INTO product_category(category_name) VALUES ('Books');
INSERT INTO product_category(category_name) VALUES ('Coffee Mugs');
INSERT INTO product_category(category_name) VALUES ('Mouse Pads');
INSERT INTO product_category(category_name) VALUES ('Luggage Tags');