package com.aviato.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname",  length = 20)
    private String firstName;


    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "lastname", length = 20)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;


    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToMany(mappedBy = "usersList")
    private List<Flight> flightsList;

    public User() {
    }

    public User(Long id, String firstName, String username, String lastName, String email, LocalDate dob, String phoneNumber, String password, String token, List<Flight> flightsList) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    public User(User copy) {
        this.id = copy.id;
        this.firstName = copy.firstName;
        this.username = copy.username;
        this.lastName = copy.lastName;
        this.email = copy.email;

        this.password = copy.password;
//        this.token = copy.token;
//        this.flightsList = new ArrayList<>(copy.flightsList);
    }



    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getToken() {
//        return token;
//    }

//    public void setToken(String token) {
//        this.token = token;
//    }

//    public List<FlightUser> getFlightUserList() {
//        return flightUserList;
//    }

//    public void setFlightUserList(List<FlightUser> flightUserList) {
//        this.flightUserList = flightUserList;
//    }

    public List<Flight> getFlightsList() {
        return this.flightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        this.flightsList = flightsList;
    }
}
