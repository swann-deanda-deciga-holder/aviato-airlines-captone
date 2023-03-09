package com.aviato.demo.models;

<<<<<<< HEAD
import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int totalSeats;
    private int availableSeats;
    private double price;

    public Flight(String flightNumber, String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int totalSeats, int availableSeats, double price) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    // Getters and setters for all fields

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
=======
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false, precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "departureAirport", nullable = false, length = 50)
    private String departureAirport;

    @Column(name = "departureCity", nullable = false, length = 50)
    private String departureCity;

    @Column(name = "arrivalAirport", nullable = false, length = 50)
    private String arrivalAirport;

    @Column(name = "arrivalCity", nullable = false, length = 50)
    private String arrivalCity;

    @Column(name = "layoverLocation", length = 50)
    private String layoverLocation;

    @Column(name = "arrivalTime", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "durationMinutes", nullable = false)
    private int durationMinutes;

    @Column(name = "departureTime", nullable = false)
    private LocalDateTime departureTime;

    @Column(name= "is_Booked")
    private boolean isBooked;

    private int seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinTable(name = "flight_user",
//            joinColumns = @JoinColumn(name = "flight_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> usersList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "flight_user",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> usersList;
    public Flight() {
        this.seat = 100;
    }
    public Flight(Long id, BigDecimal price, String departureAirport, String departureCity, String arrivalAirport, String arrivalCity, String layoverLocation, LocalDateTime arrivalTime, int durationMinutes, LocalDateTime departureTime, boolean isBooked, int seat, User user, List<User> usersList) {
        this.id = id;
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
        this.user = user;
        this.usersList = usersList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
>>>>>>> dc828e633f7b610bbcf36394ce45c848da604b93
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

<<<<<<< HEAD
=======
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

>>>>>>> dc828e633f7b610bbcf36394ce45c848da604b93
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

<<<<<<< HEAD
    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
=======
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

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }


    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
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

// Time conversion mm:Hh
//public static String minuteToTime(int minute) {
//    int hour = minute / 60;
//    minute %= 60;
//    String p = "AM";
//    if (hour >= 12) {
//        hour %= 12;
//        p = "PM";
//    }
//    if (hour == 0) {
//        hour = 12;
//    }
//    return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + " " + p;
//}

    //Time Conversion military : regular



}
>>>>>>> dc828e633f7b610bbcf36394ce45c848da604b93
