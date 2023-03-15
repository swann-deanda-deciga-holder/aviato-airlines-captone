package com.aviato.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airline", nullable = false, length = 50)
    private String airline;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "departure_airport", nullable = false, length = 50)
    private String departureAirport;

    @Column(name = "departure_city", nullable = false, length = 50)
    private String departureCity;

    @Column(name = "arrival_airport", nullable = false, length = 50)
    private String arrivalAirport;

    @Column(name = "arrival_city", nullable = false, length = 50)
    private String arrivalCity;

    @Column(name = "layover_location", length = 50)
    private String layoverLocation;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "is_booked", nullable = false)
    private Boolean isBooked;

    @Column(name = "seat", nullable = false)
    private String seat;

    @ManyToMany(mappedBy = "flightsList")
    private List<User> usersList;

    public Flight() {
    }

    public Flight(Long id, String airline, Double price, String departureAirport, String departureCity,
                  String arrivalAirport, String arrivalCity, String layoverLocation, LocalDateTime arrivalTime,
                  Integer durationMinutes, LocalDateTime departureTime, Boolean isBooked, String seat, List<User> usersList) {
        this.id = id;
        this.airline = airline;
        this.price = price;
        this.departureAirport = departureAirport;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalCity = arrivalCity;
        this.layoverLocation = layoverLocation;
        this.arrivalTime = arrivalTime;
        this.durationMinutes = durationMinutes;
        this.departureTime = departureTime;
        this.isBooked = isBooked;
        this.seat = seat;
        this.usersList = usersList;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getLayoverLocation() {
        return layoverLocation;
    }

    public void setLayoverLocation(String layoverLocation) {
        this.layoverLocation = layoverLocation;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
