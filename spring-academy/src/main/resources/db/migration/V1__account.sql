CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(9),
    name VARCHAR(50) NOT NULL,
    UNIQUE (number)
);

-- Accounts
INSERT INTO account (number, name) VALUES ('123456789', 'Keith and Keri Donald');
INSERT INTO account (number, name) VALUES ('123456001', 'Dollie R. Adams');
INSERT INTO account (number, name) VALUES ('123456002', 'Cornelia J. Andresen');
INSERT INTO account (number, name) VALUES ('123456003', 'Coral Villareal Betancourt');
INSERT INTO account (number, name) VALUES ('123456004', 'Chad I. Cobbs');
INSERT INTO account (number, name) VALUES ('123456005', 'Michael C. Feller');
INSERT INTO account (number, name) VALUES ('123456006', 'Michael J. Grover');
INSERT INTO account (number, name) VALUES ('123456007', 'John C. Howard');
INSERT INTO account (number, name) VALUES ('123456008', 'Ida Ketterer');
INSERT INTO account (number, name) VALUES ('123456009', 'Laina Ochoa Lucero');
INSERT INTO account (number, name) VALUES ('123456010', 'Wesley M. Mayo');
INSERT INTO account (number, name) VALUES ('123456011', 'Leslie F. Mcclary');
INSERT INTO account (number, name) VALUES ('123456012', 'John D. Mudra');
INSERT INTO account (number, name) VALUES ('123456013', 'Pietronella J. Nielsen');
INSERT INTO account (number, name) VALUES ('123456014', 'John S. Oleary');
INSERT INTO account (number, name) VALUES ('123456015', 'Glenda D. Smith');
INSERT INTO account (number, name) VALUES ('123456016', 'Willemina O. Thygesen');
INSERT INTO account (number, name) VALUES ('123456017', 'Antje Vogt');
INSERT INTO account (number, name) VALUES ('123456018', 'Julia Weber');
INSERT INTO account (number, name) VALUES ('123456019', 'Mark T. Williams');
INSERT INTO account (number, name) VALUES ('123456020', 'Christine J. Wilson');