package com.aviato.demo.repositories;

import com.aviato.demo.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights, Long> {

    // SELECT * FROM User WHERE flightNumber = ?;
    Flights findByFlightNumber(String flightNumber);
}


//https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/