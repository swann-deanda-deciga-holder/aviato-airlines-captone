package com.aviato.demo.models;

import com.sun.jdi.ClassType;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_id", nullable = false, unique = true)
    private String uniqueSeatId;

    @Column(name="class", nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name= "is_Booked")
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flights flight;

    public Seats() {
    }

    public Seats(Long id, String uniqueSeatId, SeatType seatType, boolean isBooked, Flights flight) {
        this.id = id;
        this.uniqueSeatId = uniqueSeatId;
        this.seatType = seatType;
        this.isBooked = isBooked;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueSeatId() {
        return uniqueSeatId;
    }

    public void setUniqueSeatId(String uniqueSeatId) {
        this.uniqueSeatId = uniqueSeatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Flights getFlight() {
        return flight;
    }

    public boolean bookSeat(){
        if(!isBooked){
            isBooked = true;
            return true;
        }
        return false;
    }

    public boolean unBookSeat(){
        if(isBooked){
            isBooked = false;
            return true;
        }
        return false;
    }
    public void setFlight(Flights flight) {
        this.flight = flight;
    }


}
