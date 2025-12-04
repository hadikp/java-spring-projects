CREATE TABLE catalog_item_history (
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    catalog_item_id BIGINT UNSIGNED NOT NULL,
    `parameter` VARCHAR(1000),
    `comment`   VARCHAR(250),
    modified TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP, -- automatikus frissítés módosításkor
    CONSTRAINT fk_ci_history_ci
        FOREIGN KEY (catalog_item_id)
        REFERENCES catalog_item(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO catalog_item_history (catalog_item_id, parameter, comment, modified)
VALUES (1, '{"limit":"5000","currency":"HUF"}', 'Limit módosítása 5000 HUF-ra', '2025-11-17 10:15:00');

INSERT INTO catalog_item_history (catalog_item_id, parameter, comment, modified)
VALUES (1, '{"limit":"10000","currency":"HUF","channel":"Mobile"}', 'Csatorna hozzáadva: Mobile', '2025-11-17 11:00:00');

INSERT INTO catalog_item_history (catalog_item_id, parameter, comment, modified)
VALUES (2, '{"limit":"2000","currency":"EUR"}', 'Devizanem módosítása EUR-ra', '2025-11-17 11:30:00');

INSERT INTO catalog_item_history (catalog_item_id, parameter, comment, modified)
VALUES (3, '{"limit":"15000","currency":"USD","channel":"Web"}', 'Limit és csatorna frissítve', '2025-11-17 12:00:00');

INSERT INTO catalog_item_history (catalog_item_id, parameter, comment, modified)
VALUES (4, '{"limit":"500","currency":"GBP"}', 'Manuális ellenőrzés, nincs változás', '2025-11-17 12:30:00');
