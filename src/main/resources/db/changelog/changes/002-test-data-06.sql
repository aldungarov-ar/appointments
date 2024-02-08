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

