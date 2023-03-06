package com.aviato.demo.repositories;

import com.aviato.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//CREATE --This is done when making an account
// DOB, First Name, Last Name, Phone number, Password -> creating a new account
User save(User user);

//READ/FIND
Optional<User> findByUsername(String username);
Optional<User> findByEmail(String Email);


//UPDATE/EDIT -- this occurs on the profile page
// DOB, First Name, Last Name, Phone number, Password
//https://www.baeldung.com/spring-data-jpa-save-saveandflush
//Allows us to save the user entity to the db and immediately flush any changes to the db
User saveAndFlush(User user);


//DELETE -- when button on profile page
//--THEIR ACCOUNT
void delete(User user);
}


//Reference to Repositories
//https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/

