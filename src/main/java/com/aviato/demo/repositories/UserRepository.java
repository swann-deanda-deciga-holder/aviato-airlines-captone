package com.aviato.demo.repositories;

import com.aviato.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // FindByEmail is being used to find user's email within the login controller. //
    User findByEmail(String email);

    User findByUsername(String username);
}