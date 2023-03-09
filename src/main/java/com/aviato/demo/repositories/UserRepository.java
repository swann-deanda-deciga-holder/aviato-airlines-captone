package com.aviato.demo.repositories;

import com.aviato.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // FindByEmail is being used to find user's email within the login controller. //
    User findByEmail(String email);
<<<<<<< HEAD
=======


>>>>>>> dc828e633f7b610bbcf36394ce45c848da604b93
}