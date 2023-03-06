package com.aviato.demo.services;

import com.aviato.demo.models.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);

    boolean authenticate(String email, String password);
}
