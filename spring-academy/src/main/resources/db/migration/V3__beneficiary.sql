CREATE TABLE beneficiary (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    name VARCHAR(50),
    allocation_percentage DECIMAL(5,2) NOT NULL,
    savings DECIMAL(10,2) NOT NULL,
    UNIQUE (account_id, name),
    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE
);

-- Beneficiaries
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (1, 'Annabelle', 0.50, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (1, 'Corgan', 0.50, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (4, 'Antolin', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (4, 'Argus', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (4, 'Gian', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (4, 'Argeo', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (9, 'Kai', 0.33, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (9, 'Kasper', 0.33, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (9, 'Ernst', 0.34, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (13, 'Brian', 0.75, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (13, 'Shelby', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (16, 'Charles', 0.50, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (16, 'Thomas', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (16, 'Neil', 0.25, 0.00);
INSERT INTO beneficiary (account_id, name, allocation_percentage, savings) VALUES (18, 'Daniel', 1.00, 0.00);
