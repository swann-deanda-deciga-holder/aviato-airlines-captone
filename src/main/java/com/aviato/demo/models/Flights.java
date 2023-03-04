package com.aviato.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "flight")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "flight_id")
    private Long id;

    @Column(name = "price", nullable = false, precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "departureAirport", nullable = false, length = 50)
    private String departureAirport;

    @Column(name = "arrivalAirport", nullable = false, length = 50)
    private String arrivalAirport;

    @Column(name = "layoverLocation", length = 50)
    private String layoverLocation;

    @Column(name = "arrivalTime", nullable = false)
    private LocalDateTime arrivalTime;

    // Enumerated(EnumType.STRING) used to indicate that an enum type attribute should be persisted as a string value in the database.
    /* RESEARCH FOR SEATS

    https://stackoverflow.com/questions/60895270/airplane-seating-program-2-dimensional-array
    * */

    //Enum values are economy or first (class).  It just limits the options.
    @Enumerated(EnumType.STRING)
    @Column(name = "seatType", nullable = false, length = 15)
    private String seatType;
    @Column(name = "seatAvailable", nullable = false)
    private boolean seatAvailable;

//
//    https://github.com/vishal1605/Movie-seat-project/blob/main/src/main/java/com/bus/beans/Customer.java
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();


//    LAZY - To load it on-demand (i.e. lazily) when you call
//    EAGER - To load it together with the rest of the fields (i.e. eagerly)
//    If flight has many passengers it is not efficient to load all of its students together with it,
//    especially when they are not needed and in suchlike cases you can declare that you want students to be loaded when they are actually needed.
//    This is called lazy loading.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "flight_user",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    //would have to use a set in a many-to-many relationship
    private Set<User> users = new HashSet<>();


    public Flights() {
    }

    public Flights(Long id, BigDecimal price, String departureAirport, String arrivalAirport, String layoverLocation, LocalDateTime arrivalTime, String seatType, boolean seatAvailable, User user, Set<User> users) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.layoverLocation = layoverLocation;
        this.arrivalTime = arrivalTime;
        this.seatType = seatType;
        this.seatAvailable = seatAvailable;
        this.user = user;
        this.users = users;
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
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
