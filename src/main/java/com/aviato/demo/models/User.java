package com.aviato.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


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

    @Column(name = "token", nullable = false, length = 255)
    private String token;



//    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
//    private List<Flight> flights;

    //YESTERDAY
//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Flight> flights;

//I ADDED TODAY BY CHAT GPT
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<FlightUser> flightUserList;

    @ManyToMany(mappedBy = "usersList")
    private List<Flight> flightsList;

    public User() {
    }

//    public User(Long id, String firstName, String lastName, String email, LocalDate dob, String phoneNumber, String password, String token, List<Flight> flights) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.dob = dob;
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//        this.token = token;
//        this.flights = flights;
//    }
public User(Long id, String firstName, String lastName, String email, String password, List<Flight> flightsList) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
//    this.flightUserList = flightUserList;
    this.flightsList = flightsList;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public List<FlightUser> getFlightUserList() {
//        return flightUserList;
//    }

//    public void setFlightUserList(List<FlightUser> flightUserList) {
//        this.flightUserList = flightUserList;
//    }

    public List<Flight> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        this.flightsList = flightsList;
    }
}
