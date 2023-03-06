NSERT INTO User (firstname, lastname, email, dob, phone_number, password, token)
VALUES
('John', 'Doe', 'johndoe@example.com', '1990-01-01', '+1 123 456 7890', 'password123', 'token123'),
('Jane', 'Doe', 'janedoe@example.com', '1992-05-10', '+1 234 567 8901', 'password456', 'token456'),
('Bob', 'Smith', 'bobsmith@example.com', '1985-12-15', '+1 345 678 9012', 'password789', 'token789');

INSERT INTO flight (price, departureAirport, departureCity, arrivalAirport, arrivalCity, layoverLocation, arrivalTime, durationMinutes, departureTime, is_Booked, seat, user_id)
VALUES
    (100.00, 'LAX', 'Los Angeles', 'JFK', 'New York', NULL, '2023-03-10 12:00:00', 360, '2023-03-10 08:00:00', FALSE, 10, 1),
    (200.00, 'JFK', 'New York', 'LAX', 'Los Angeles', 'SFO', '2023-03-12 18:00:00', 420, '2023-03-12 10:00:00', TRUE, 20, 2),
    (150.00, 'SFO', 'San Francisco', 'LHR', 'London', NULL, '2023-03-15 12:00:00', 600, '2023-03-15 03:00:00', FALSE, 30, 3);

INSERT INTO token (user_id, token)
VALUES
    (1, 'token1'),
    (2, 'token2'),
    (3, 'token2');

INSERT INTO Flight_User (user_id, flight_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);




