# # CREATE DATABASE IF NOT EXISTS aviato_db;
#
#
# USE aviato_db;
#
#
#
# # CREATE TABLE User (
# # id BIGINT PRIMARY KEY AUTO_INCREMENT,
# # username varchar(20) NOT NULL
# # firstname VARCHAR(20) NOT NULL,
# # lastname VARCHAR(20) NOT NULL,
# # email VARCHAR(50) NOT NULL,
# # -- dob DATE NOT NULL,
# # -- phone_number VARCHAR(15) NOT NULL,
# # password VARCHAR(255) NOT NULL;
# # -- token VARCHAR(255) NOT NULL
# # );
#
# create database aviato_db;
#
# drop table user;
#
# use aviato_db;
#
# CREATE TABLE user (
#                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
#                       firstname VARCHAR(20),
# #                       username VARCHAR(20),
#                       lastname VARCHAR(20),
#                       email VARCHAR(50),
#                       password VARCHAR(255)
# );
#
#
#
#
#
# CREATE TABLE flight (
# id BIGINT NOT NULL AUTO_INCREMENT,
# price DECIMAL(4,2) NOT NULL,
# departureAirport VARCHAR(50) NOT NULL,
# departureCity VARCHAR(50) NOT NULL,
# arrivalAirport VARCHAR(50) NOT NULL,
# arrivalCity VARCHAR(50) NOT NULL,
# layoverLocation VARCHAR(50),
# arrivalTime DATETIME NOT NULL,
# durationMinutes INT NOT NULL,
# departureTime DATETIME NOT NULL,
# is_Booked BOOLEAN,
# seat INT NOT NULL DEFAULT 100,
# user_id BIGINT NOT NULL,
# PRIMARY KEY (id),
# FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
# );
#
#
#
# CREATE TABLE token (
# id INT NOT NULL AUTO_INCREMENT,
# user_id INT NOT NULL,
# token VARCHAR(255) NOT NULL,
# PRIMARY KEY (id),
# FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
# );
#
#
# CREATE TABLE Flight_User (
# flight_user_id INT PRIMARY KEY AUTO_INCREMENT,
# user_id INT NOT NULL,
# flight_id INT NOT NULL,
# FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
# FOREIGN KEY (flight_id) REFERENCES Flight(id)
# );
#
#
#
#
CREATE DATABASE IF NOT EXISTS aviato_db;

USE aviato_db;


CREATE TABLE user (
                      id INT NOT NULL AUTO_INCREMENT,
                      firstName varchar(20),
                      lastname varchar(20),
                      email varchar(50),
                      password varchar(255),
                      PRIMARY KEY (id)
);

CREATE TABLE payment (
                         id INT NOT NULL AUTO_INCREMENT,
                         user_id;
FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (token)  REFERENCES bluestrip(token) ,

    );

CREATE TABLE flight (
                        flight_id INT NOT NULL AUTO_INCREMENT,
                        price DECIMAL(4, 2),
                        origin VARCHAR(50),
                        destination varchar(50),
                        duration int(1000),
                        layoverLocation varchar(100),
                        seat_type varchar(15)
);

CREATE TABLE token(
                      id INT NOT NULL AUTO_INCREMENT,
                      user_id,
                      token varchar(255) NOT NULL,
                      FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);