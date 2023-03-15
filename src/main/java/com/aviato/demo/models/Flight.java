package com.aviato.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airline", nullable = false)
    private String airline;
    @Column(name = "flightNumber", nullable = false)
    private String flightNumber;
    @Column(name = "price", nullable = false, precision = 4, scale = 2)
    private BigDecimal price;
    @Column(name = "departureTime", nullable = false)
    private LocalDateTime departureTime;
    //Departure Airport -ie dfw
    @Column(name = "departureAirport", nullable = false, length = 50)
    private String departureAirport;
    @Column(name = "departureCity", nullable = false, length = 50)
    private String departureCity;
    @Column(name = "arrivalAirport", nullable = false, length = 50)
    private String arrivalAirport;
    @Column(name = "arrivalCity", nullable = false, length = 50)
    private String arrivalCity;
    @Column(name = "arrivalTime", nullable = false)
    private LocalDateTime arrivalTime;
    @Column(name = "layoverCount", length = 50)
    private String layoverCount;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name= "is_roundTrip")
    private boolean roundTrip;
    @Column(name= "is_Booked")
    private boolean isBooked;
    @Column(name = "cabin", nullable = false)
    private String cabin;
    @Column(name = "seat", nullable = false)
    private int seat;

    @Column(name = "adult")
    private int adult;

    @Column(name = "child", nullable = false)
    private int child;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "flight_user",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))



    private List<User> usersList;
    public Flight() {
        this.seat = 100;
    }

    public Flight(Long id, String airline, String flightNumber, BigDecimal price, LocalDateTime departureTime, String departureAirport, String departureCity, String arrivalAirport, String arrivalCity, LocalDateTime arrivalTime, String layoverCount, String duration, boolean roundTrip, boolean isBooked, String cabin, int seat, int adult, int child, User user, List<User> usersList) {
        this.id = id;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.price = price;
        this.departureTime = departureTime;
        this.departureAirport = departureAirport;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
        this.layoverCount = layoverCount;
        this.duration = duration;
        this.roundTrip = roundTrip;
        this.isBooked = isBooked;
        this.cabin = cabin;
        this.seat = seat;
        this.adult = adult;
        this.child = child;
        this.user = user;
        this.usersList = usersList;
    }

    // method to update seats based on number of seats booked
    public void updateSeats(int numSeats) {
        this.seat -= numSeats; // subtract numSeats from seats
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLayoverCount() {
        return layoverCount;
    }

    public void setLayoverCount(String layoverCount) {
        this.layoverCount = layoverCount;
    }

    public boolean isRoundTrip() {
        return roundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}