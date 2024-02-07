DROP TABLE IF EXISTS shifts;

CREATE TABLE shifts (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    period VARCHAR(50) NOT NULL,
    time_start TIME WITHOUT TIME ZONE,
    time_end TIME WITHOUT TIME ZONE,
    doctor_id INTEGER NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors (id)
);