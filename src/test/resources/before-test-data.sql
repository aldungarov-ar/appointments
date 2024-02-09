    INSERT INTO specializations
        (id, name, appointment_duration) VALUES
        (0, 'Cardiology', 30),
        (1, 'Dermatology', 20),
        (2, 'Neurology', 45);

    INSERT INTO patients
        (id, uuid, first_name, last_name, middle_name, birth_date, gender) VALUES
        (0, '123e4567-e89b-12d3-a456-426614174100', 'Michael', 'Brown', '', '1985-04-12', 'M'),
        (1, '123e4567-e89b-12d3-a456-426614174101', 'Sarah', 'Wilson', 'C.', '1992-08-25', 'F'),
        (2, '123e4567-e89b-12d3-a456-426614174102', 'William', 'Taylor', 'D.', '1978-11-02', 'M');

    INSERT INTO doctors
        (id, uuid, first_name, last_name, middle_name, specialization_id, grade) VALUES
        (0, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'John', 'Doe', 'Allen', 1, 'A'),
        (1, '550e8400-e29b-41d4-a716-446655440000', 'Jane', 'Smith', 'Beth', 2, 'B'),
        (2, 'c9b1db4a-c3ac-446b-9e6c-7d8ac4a4f3a5', 'Emily', 'Johnson', 'Claire', 0, 'C');

    INSERT INTO shifts
        (id, date, period, time_start, time_end, doctor_id) VALUES
        (0, '2024-02-15', 'DAY', '09:00:00', '16:00:00', 1),
        (1, '2024-02-16', 'EVENING', '16:00:00', '20:00:00', 1),
        (2, '2024-02-17', 'NIGHT', '00:00:00', '09:00:00', 2),
        (3, '2024-02-18', 'ALL_DAY', '09:00:00', '20:00:00', 0),
        (4, '2024-02-19', 'DAY', '08:00:00', '16:00:00', 2),
        (5, '2024-02-20', 'EVENING', '16:00:00', '00:00:00', 0),
        (6, '2024-02-21', 'NIGHT', '00:00:00', '09:00:00', 1),
        (7, '2024-02-22', 'ALL_DAY', '09:00:00', '20:00:00', 0);

    INSERT INTO appointments
        (id, doctor_id, patient_id, start_time, end_time, duration, first_time, shift_id) VALUES
        (0, 1, 1, '2024-02-10 09:00:00', '2024-02-10 09:30:00', '30 minutes', TRUE, 0),
        (1, 2, 2, '2024-02-10 10:00:00', '2024-02-10 10:30:00', '30 minutes', FALSE, 1),
        (2, 0, 0, '2024-02-11 11:00:00', '2024-02-11 11:30:00', '30 minutes', TRUE, 2);

