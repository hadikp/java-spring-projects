CREATE TABLE IF NOT EXISTS `product_category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO product_category (category_name) VALUES ('BOOKS');