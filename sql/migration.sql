CREATE TABLE aviato_db.user (
                                id INT NOT NULL AUTO_INCREMENT,
                                first_name VARCHAR(50) NOT NULL,
                                last_name VARCHAR(50) NOT NULL,
                                email VARCHAR(100) NOT NULL,
                                password VARCHAR(255) NOT NULL,
                                PRIMARY KEY (id),
                                UNIQUE KEY (email)
);
