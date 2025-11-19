CREATE TABLE catalog_item (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_value VARCHAR(100),
    name VARCHAR(255) NOT NULL,
    catalog_id BIGINT UNSIGNED NOT NULL,
    modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (catalog_id) REFERENCES catalog(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Katalógus elemek Elektronikus csatorna típusa
INSERT INTO catalog_item (item_value, name, catalog_id, modified) VALUES ('1', 'Email', 1, CURRENT_TIMESTAMP);
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (1, '2', 'CIB Bank Mobilalkalmazás/CIB Bank Online');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (1, '3', 'Elektronikus csatornák');

-- Katalógus elemek - Tranzakciós paraméterek
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (2, '1', 'Tranzakció dátuma');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (2, '2', 'Tranzakció összege');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (2, '3', 'Tranzakció devizanem');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (2, '4', 'Kártyaszám');

-- Katalógus elemek - Devizanem
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (3, '1', 'HUF');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (3, '2', 'EUR');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (3, '3', 'GBP');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (3, '4', 'USD');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (3, '5', 'AUD');

-- Katalógus elemek - Írásos visszajelzés módja
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (4, '1', 'Email');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (4, '2', 'Postai levél');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (4, '3', 'SMS');

-- Katalógus elemek - Reklamáció típusa
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (5, '1', 'ATM');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (5, '2', 'POS');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (5, '3', 'ECI');

-- Katalógus elemek - Panasz kiváltó oka
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (6, '1', 'Késedelmes jóváírás');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (6, '2', 'Hibás tranzakció');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (6, '3', 'Technikai hiba');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (6, '4', 'Nem megfelelő ügyintézés');

-- Katalógus elemek Panasztípus
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (7, '1', 'Szóbeli panasz CIB24-en');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (7, '2', 'Szóbeli panasz fiókban');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (7, '3', 'Írásbeli panasz CIB24-en');
INSERT INTO catalog_item (catalog_id, item_value, name) VALUES (7, '4', 'Postán érkezett');