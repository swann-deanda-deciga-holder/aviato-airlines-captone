package com.aviato.demo.models;

import jakarta.persistence.*;

import java.util.List;

public class FlightUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable = false)
    private Flight flight;

   @OneToMany(mappedBy = "flightsToUser")
    private List<User> usersList;
    public FlightUser() {
    }

    public FlightUser(Long id, User user, Flight flight, List<User> usersList) {
        this.id = id;
        this.user = user;
        this.flight = flight;
        this.usersList = usersList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
