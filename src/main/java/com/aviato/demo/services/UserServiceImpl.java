package com.aviato.demo.services;

import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

//    public void update(User user) {
//        userRepository.save(user);
//    }
//
//    public void delete(User user) {
//        userRepository.delete(user);
//    }
//
//    public boolean authenticate(String email, String password) {
//        User user = findByEmail(email);
//        if (user == null) {
//            return false;
//        }
//        return passwordEncoder.matches(password, user.getPassword());
//    }

}