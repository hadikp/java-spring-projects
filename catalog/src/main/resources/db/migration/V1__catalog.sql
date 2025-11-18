CREATE TABLE catalog (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Katalógusok
INSERT INTO catalog (name, description) VALUES ('Elektronikus csatorna típusa', 'Csatornák felsorolása');
INSERT INTO catalog (name, description) VALUES ('Tranzakciós paraméterek', 'Manuális tranzakció felvételhez szükséges adatok');
INSERT INTO catalog (name, description) VALUES ('Devizanem', 'Devizák típusai');
INSERT INTO catalog (name, description) VALUES ('Írásos visszajelzés módja', 'Írásbeli kommunikáció formái');
INSERT INTO catalog (name, description) VALUES ('Reklamáció típusa', 'Milyen tranzakcióval kapcsolatosan történt a  reklamáció');
INSERT INTO catalog (name, description) VALUES ('Panasz kiváltó ok', 'Miért történt a panasz');
INSERT INTO catalog (name, description) VALUES ('Panasztípus', 'A panasz típusa');