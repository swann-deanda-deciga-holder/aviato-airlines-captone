CREATE DATABASE IF NOT EXISTS aviato_db;
USE aviato_db;

CREATE TABLE flight(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    airline VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL ,
    departure_airport VARCHAR(50) NOT NULL,
    departure_city VARCHAR(50) NOT NULL,
    arrival_airport VARCHAR(50) NOT NULL,
    arrival_city VARCHAR(50) NOT NULL,
    layover_count INT UNSIGNED,
    arrival_time VARCHAR(50) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    departure_time VARCHAR(50) NOT NULL,
    is_booked TINYINT(1),
    seat INT UNSIGNED,
    PRIMARY KEY (id)
    );

CREATE TABLE flight_user(
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       user_id INT unsigned NOT NULL,
                       flight_id INT unsigned NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES user(id),
                       FOREIGN KEY (flight_id) REFERENCES flight(id),
                       PRIMARY KEY (id)
);
