-- Először a szülőtábla (Route), mivel arra hivatkozunk később
CREATE TABLE IF NOT EXISTS trainings (
    id bigint auto_increment PRIMARY KEY,
    type VARCHAR(50), sun_month_km DECIMAL(5,1), sum_year_km DECIMAL(5,1), training_date date
);

-- A gyerektábla (Trackpoint), amely idegen kulcsot tartalmaz a Route-ra
CREATE TABLE IF NOT EXISTS runs (
    id bigint auto_increment PRIMARY KEY,
    type VARCHAR(50), description VARCHAR(255), km DOUBLE, run_date DATE,
    training_id BIGINT,
    CONSTRAINT fk_run_training FOREIGN KEY (training_id) REFERENCES trainings(id)
);