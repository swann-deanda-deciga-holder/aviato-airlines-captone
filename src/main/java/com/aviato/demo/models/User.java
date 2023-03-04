package com.aviato.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Payment> payments = new HashSet<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Token> tokens = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Payment> payments;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private Set<Flights> flights;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, LocalDate dob, String phoneNumber, String password, Set<Payment> payments, Set<Flights> flights) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.payments = payments;
        this.flights = flights;
    }


}
