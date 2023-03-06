package com.aviato.demo.repositories;

import com.aviato.demo.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, Long> {

    //READ/FIND
    //Find seats by ID
    Seats findById(Long id);








}

//I want the user to find a seat.  Once that seat is selected it is unavailable.
// I want the user to remove a seat
//https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/