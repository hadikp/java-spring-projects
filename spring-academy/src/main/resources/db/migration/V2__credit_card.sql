CREATE TABLE credit_card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    number VARCHAR(16),
    UNIQUE (account_id, number),
    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE
);

-- Credit Cards
INSERT INTO credit_card (account_id, number) VALUES (1, '1234123412341234');
INSERT INTO credit_card (account_id, number) VALUES (2, '1234123412340001');
INSERT INTO credit_card (account_id, number) VALUES (3, '1234123412340002');
INSERT INTO credit_card (account_id, number) VALUES (4, '1234123412340003');
INSERT INTO credit_card (account_id, number) VALUES (5, '1234123412340004');
INSERT INTO credit_card (account_id, number) VALUES (6, '1234123412340005');
INSERT INTO credit_card (account_id, number) VALUES (7, '1234123412340006');
INSERT INTO credit_card (account_id, number) VALUES (8, '1234123412340007');
INSERT INTO credit_card (account_id, number) VALUES (9, '1234123412340008');
INSERT INTO credit_card (account_id, number) VALUES (10, '1234123412340009');
INSERT INTO credit_card (account_id, number) VALUES (11, '1234123412340010');
INSERT INTO credit_card (account_id, number) VALUES (12, '1234123412340011');
INSERT INTO credit_card (account_id, number) VALUES (13, '1234123412340012');
INSERT INTO credit_card (account_id, number) VALUES (14, '1234123412340013');
INSERT INTO credit_card (account_id, number) VALUES (15, '1234123412340014');
INSERT INTO credit_card (account_id, number) VALUES (16, '1234123412340015');
INSERT INTO credit_card (account_id, number) VALUES (17, '1234123412340016');
INSERT INTO credit_card (account_id, number) VALUES (18, '1234123412340017');
INSERT INTO credit_card (account_id, number) VALUES (19, '1234123412340018');
INSERT INTO credit_card (account_id, number) VALUES (20, '1234123412340019');
INSERT INTO credit_card (account_id, number) VALUES (21, '1234123412340020');