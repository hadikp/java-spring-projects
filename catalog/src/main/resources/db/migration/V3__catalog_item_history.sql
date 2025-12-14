CREATE TABLE catalog_item_history (
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    catalog_id BIGINT UNSIGNED NOT NULL,
    `parameter` LONGTEXT,  -- nagy szöveg, JSON tárolásra ideális
    `comment`   VARCHAR(250),
     modified TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_ci_history_ci
        FOREIGN KEY (catalog_id)
        REFERENCES catalog(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_parameter_json_valid CHECK (parameter IS NULL OR JSON_VALID(parameter)) -- opcionális JSON ellenőrzés
) ENGINE=InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (1, '{"value":"1","name":"Email"}', 'Kezdő adat', '2025-11-17 10:15:00');

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (1, '[{"value":"1","name":"Email"}, {"value":"2","name":"CIB Bank Mobilalkalmazás/CIB Bank Online"}]', 'Cib bak hozzáadva', '2025-11-17 11:00:00');

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (1, '[{"value":"1","name":"Email"},{"value":"2","name":"CIB Bank Mobilalkalmazás/CIB Bank Online"},{"value":"3","name":"Elektronikus csatornák"}]', 'Elektronikus csatornák hozzáadva', '2025-11-17 11:30:00');

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (2, '{"value":"1","name":"Tranzakció dátuma"}', 'Tranzakció dátuma', '2025-11-17 12:00:00');

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (2, '[{"value":"1","name":"Tranzakció dátuma"}, {"value":"2","name":"Tranzakció összege"}]', 'Tranzakció összege hozzáadva', '2025-11-17 12:30:00');

INSERT INTO catalog_item_history (catalog_id, parameter, comment, modified)
VALUES (3, '[{"value":"1","name":"HUF"}, {"value":"2","name":"EUR"}]', 'Devizák', '2025-11-17 12:30:00');
