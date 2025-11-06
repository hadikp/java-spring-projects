CREATE TABLE restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    merchant_number VARCHAR(10) NOT NULL,
    name VARCHAR(80) NOT NULL,
    benefit_percentage DECIMAL(5,2) NOT NULL,
    benefit_availability_policy CHAR(1) NOT NULL,
    UNIQUE (merchant_number)
);

-- Restaurant
INSERT INTO restaurant (merchant_number, name, benefit_percentage, benefit_availability_policy)
VALUES ('1234567890', 'AppleBees', 0.08, 'A');