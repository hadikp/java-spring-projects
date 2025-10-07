CREATE TABLE IF NOT EXISTS `product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` TINYINT(1) DEFAULT 1,
  `units_in_stock` INT DEFAULT NULL,
  `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES
('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript',
 'assets/images/products/placeholder.png', b'1', 100, 19.99, 1, NOW()),

('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring',
 'assets/images/products/placeholder.png', b'1', 100, 29.99, 1, NOW()),

('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes',
 'assets/images/products/placeholder.png', b'1', 100, 24.99, 1, NOW()),

('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
 'assets/images/products/placeholder.png', b'1', 100, 29.99, 1, NOW()),

('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go',
 'assets/images/products/placeholder.png', b'1', 100, 24.99, 1, NOW());
