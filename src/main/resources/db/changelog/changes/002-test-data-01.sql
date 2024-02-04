    INSERT INTO doctors
        (uuid, first_name, last_name, middle_name, specialization, grade) VALUES
        ('123e4567-e89b-12d3-a456-426614174000', 'John', 'Doe', 'A.', 'Cardiology', 'Senior'),
        ('123e4567-e89b-12d3-a456-426614174001', 'Jane', 'Smith', 'B.', 'Neurology', 'Consultant'),
        ('123e4567-e89b-12d3-a456-426614174002', 'Emily', 'Jones', '', 'Pediatrics', 'Junior');

    INSERT INTO patients
        (uuid, first_name, last_name, middle_name, birth_date, gender) VALUES
        ('123e4567-e89b-12d3-a456-426614174100', 'Michael', 'Brown', '', '1985-04-12', 'M'),
        ('123e4567-e89b-12d3-a456-426614174101', 'Sarah', 'Wilson', 'C.', '1992-08-25', 'F'),
        ('123e4567-e89b-12d3-a456-426614174102', 'William', 'Taylor', 'D.', '1978-11-02', 'M');

    -- Assuming doctor_id and patient_id are correctly assigned based on the inserted doctors and patients
    INSERT INTO appointments
        (doctor_id, patient_id, start_time, end_time, duration, first_time) VALUES
        (1, 1, '2024-02-10 09:00:00', '2024-02-10 09:30:00', '30 minutes', TRUE),
        (2, 2, '2024-02-10 10:00:00', '2024-02-10 10:30:00', '30 minutes', FALSE),
        (3, 3, '2024-02-11 11:00:00', '2024-02-11 11:30:00', '30 minutes', TRUE);

