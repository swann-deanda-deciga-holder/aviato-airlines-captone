package com.aviato.demo.repositories;

import com.aviato.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    // SELECT * FROM User WHERE flightNumber = ?;

    // There is not flightNumber field in the flight class. //

//    Flight findByFlightNumber(String flightNumber);
}


////https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/