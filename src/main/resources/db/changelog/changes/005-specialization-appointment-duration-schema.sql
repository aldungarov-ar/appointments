DROP TABLE IF EXISTS specializations;

CREATE TABLE specializations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    -- Duration of the appointment in minutes --
    appointment_duration INTEGER NOT NULL
);