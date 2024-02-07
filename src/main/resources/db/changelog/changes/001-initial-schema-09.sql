DROP TABLE IF EXISTS doctors CASCADE;
DROP TABLE IF EXISTS specializations CASCADE;
DROP TABLE IF EXISTS patients CASCADE;
DROP TABLE IF EXISTS shifts CASCADE;
DROP TABLE IF EXISTS appointments CASCADE;

CREATE TABLE specializations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    -- Duration of the appointment in minutes --
    appointment_duration INTEGER NOT NULL
);

CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    birth_date DATE,
    gender CHAR(1)
);

CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    specialization_id INTEGER NOT NULL,
    grade VARCHAR(256),
    FOREIGN KEY (specialization_id) REFERENCES specializations (id)
);

CREATE TABLE shifts (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    period VARCHAR(50) NOT NULL,
    time_start TIME WITHOUT TIME ZONE,
    time_end TIME WITHOUT TIME ZONE,
    doctor_id INTEGER NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors (id)
);

CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    doctor_id INTEGER NOT NULL,
    patient_id INTEGER,
    start_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    duration INTERVAL NOT NULL,
    first_time BOOLEAN,
    shift_id INTEGER NOT NULL,
    FOREIGN KEY (shift_id) REFERENCES shifts (id),
    FOREIGN KEY (doctor_id) REFERENCES doctors (id),
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);