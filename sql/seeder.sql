INSERT INTO user (username, firstname, lastname, email, password)
VALUES
    (null, 'John', 'Doe', 'john.doe@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
    (null, 'Jane', 'Doe', 'jane.doe@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
    (null, 'Bob', 'Smith', 'bob.smith@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
    (null, 'Alice', 'Smith', 'alice.smith@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123');


INSERT INTO flight (id, airline, flight_number, price, departure_time, departure_airport, departure_city, arrival_airport, arrival_city, arrival_time, layover_count, duration, is_round_Trip, is_booked, cabin, seat, adult, child)
VALUES
    (1, 'Airline 1', 'FL001', 100.00, '2023-03-15 10:00:00', 'Airport A', 'City A', 'Airport B', 'City B', '2023-03-15 12:00:00', '0', '2h 0m', false, false, 'Economy', 0, 0, 0),
    (2, 'Airline 2', 'FL002', 150.00, '2023-03-16 09:00:00', 'Airport C', 'City C', 'Airport D', 'City D', '2023-03-16 12:00:00', '1', '3h 0m', true, true, 'Business', 1, 2, 1),
    (3, 'Airline 3', 'FL003', 200.00, '2023-03-17 12:00:00', 'Airport E', 'City E', 'Airport F', 'City F', '2023-03-17 15:00:00', '0', '3h 0m', true, false, 'First Class', 2, 2, 0);
