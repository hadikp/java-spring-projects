DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  category_name VARCHAR(255)
);

CREATE TABLE product (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  sku VARCHAR(255),
  name VARCHAR(255),
  description VARCHAR(255),
  unit_price DECIMAL(13,2),
  image_url VARCHAR(255),
  active BOOLEAN DEFAULT TRUE,
  units_in_stock INT,
  date_created TIMESTAMP,
  last_updated TIMESTAMP,
  category_id BIGINT,
  FOREIGN KEY (category_id) REFERENCES product_category(id)
);
