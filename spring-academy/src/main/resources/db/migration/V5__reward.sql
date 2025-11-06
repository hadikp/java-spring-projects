CREATE TABLE reward (
    id INT AUTO_INCREMENT PRIMARY KEY,
    confirmation_number VARCHAR(25) NOT NULL,
    reward_amount DECIMAL(10,2) NOT NULL,
    reward_date DATE NOT NULL,
    account_number VARCHAR(9) NOT NULL,
    dining_amount DECIMAL(10,2) NOT NULL,
    dining_merchant_number VARCHAR(10) NOT NULL,
    dining_date DATE NOT NULL,
    UNIQUE (confirmation_number)
);