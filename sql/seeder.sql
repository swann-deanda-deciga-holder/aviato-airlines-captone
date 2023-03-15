# INSERT INTO user (username, firstname, lastname, email, password)
# VALUES
#     (null, 'John', 'Doe', 'john.doe@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
#     (null, 'Jane', 'Doe', 'jane.doe@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
#     (null, 'Bob', 'Smith', 'bob.smith@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123'),
#     (null, 'Alice', 'Smith', 'alice.smith@example.com', '$2a$10$1234567890abcdefghijklmnopqrstuvwxyz0123');

INSERT INTO flight (airline, arrival_airport, arrival_city, arrival_time, departure_time, duration_minutes, is_booked, layover_location, price, seat, user_id)
VALUES
    (null, 'American Airlines', 'Love Field', 'Dallas', '1300', '0800', '60m', 'yes', 'n/a', '$50', '10A', 1);
