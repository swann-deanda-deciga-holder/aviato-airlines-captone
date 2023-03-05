USE aviato_db;


CREATE TABLE user (
id INT NOT NULL AUTO_INCREMENT,
userName varchar(20) NOT NULL,
firstName varchar(20) NOT NULL,
lastname varchar(20) NOT NULL,
email varchar(50) NOT NULL,
password varchar(255) NOT NULL,
PRIMARY KEY (id)
);

# --WE MADE THIS IN CLASS
-- CREATE TABLE payment (
-- id INT NOT NULL AUTO_INCREMENT,
-- user_id;
-- FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
-- FOREIGN KEY (token)  REFERENCES bluestrip(token) ,
--
-- );
# CREATE TABLE payment (
# id INT NOT NULL AUTO_INCREMENT,
# user_id INT NOT NULL,
# token VARCHAR(255) NOT NULL,
# PRIMARY KEY (id),
# FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE,
# FOREIGN KEY (token) REFERENCES token(token)
# );

CREATE TABLE flight (
id INT AUTO_INCREMENT NOT NULL,
PRIMARY KEY (id),
price DECIMAL(4, 2) NOT NULL,
origin VARCHAR(50) NOT NULL,
destination varchar(50) NOT NULL,
duration int(255) NOT NULL,
layoverLocation varchar(100) NOT NULL,
seat_type varchar(15)
);

# --WE MADE THIS IN CLASS
-- CREATE TABLE token(
--     id INT NOT NULL AUTO_INCREMENT,
--     PRIMARY KEY (ID);
--     user_id NOT NULL,
--     token varchar(255) NOT NULL,
--     FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
-- );

CREATE TABLE token (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
token VARCHAR(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- Flight_User join table (Table 3)
CREATE TABLE Flight_User (
flight_user_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
flight_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
FOREIGN KEY (flight_id) REFERENCES Flight(id)
);

# NEED TO REEVALUATE
CREATE TABLE seats (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(id),
unique_id VARCHAR(255) NOT NULL UNIQUE,
class VARCHAR(255) NOT NULL,
is_booked BOOLEAN DEFAULT false NOT NULL,
flight_id INTEGER REFERENCES flight(id)
);

