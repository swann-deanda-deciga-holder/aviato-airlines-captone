INSERT INTO user (username, firstname, lastname, email, password)
VALUES
    (null, 'John', 'Doe', 'john.doe@example.com', '$2a$10$M9dSMk4ZWEdIvUU2kL/fM.TQsU6BbWGQTpdCU/u1DZ1tJkzEBbWmy'),
    #pw: JohnDoePassword1!
    (null, 'Jane', 'Doe', 'jane.doe@example.com', '$2a$10$UEI.l9G3dBiHn4PCmy9tkejZRr3LvA25sRTBYitQK/YA1f5zImRkS'),
    #pw: JaneDoePassword1!
    (null, 'Bob', 'Smith', 'bob.smith@example.com', '$2a$10$qOjQN0FBBDOoFyANTx8pfO2BwLoQEND/gqhmlonUUh7tuXTiAxjwW'),
    #pw: BobSmithPassword1!
    (null, 'Alice', 'Smith', 'alice.smith@example.com', '$2a$10$qOjQN0FBBDOoFyANTx8pfO2BwLoQEND/gqhmlonUUh7tuXTiAxjwW');
    #pw: AliceSmithPassword1!


INSERT INTO flight (airline, price, departure_airport, departure_city, arrival_airport,arrival_city,layover_count,arrival_time, duration, departure_time, is_booked, seat)

VALUES
        ("Test Airlines1", 100.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 1),
        ("Test Airlines2", 159.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 2),
        ("Test Airlines3", 177.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 3),
        ("Test Airlines4", 100.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 1),
        ("Test Airlines5", 159.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 2),
        ("Test Airlines6", 177.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 3),
        ("Test Airlines7", 100.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 1),
        ("Test Airlines8", 159.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 2),
        ("Test Airlines9", 177.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 3),
        ("Test Airlines10", 100.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 1),
        ("Test Airlines11", 159.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 2),
        ("Test Airlines12", 177.00, "DFW", "Dallas", "JFK", "New York City", 0, "2019-08-20 10:22:34" , "55m","2019-08-20 10:22:34", true, 3);




