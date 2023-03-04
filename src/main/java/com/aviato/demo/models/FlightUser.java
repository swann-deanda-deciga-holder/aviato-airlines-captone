package com.aviato.demo.models;

import jakarta.persistence.*;

public class FlightUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable = false)
    private Flights flight;

    public FlightUser() {
    }

    public FlightUser(Long id, User user, Flights flight) {
        this.id = id;
        this.user = user;
        this.flight = flight;
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

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }
}
