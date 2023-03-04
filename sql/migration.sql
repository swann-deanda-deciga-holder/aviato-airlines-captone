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