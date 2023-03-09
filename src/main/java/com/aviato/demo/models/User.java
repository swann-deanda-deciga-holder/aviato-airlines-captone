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
    @Column(name = "username",  length = 20, nullable = true)
    private String username;
    @Column(name = "firstname",  length = 20, nullable = false)
    private String firstName;



    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

<<<<<<< HEAD

=======
>>>>>>> 05bb174aa9342cc57e94181ccb616b912c2af38a
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToMany(mappedBy = "usersList")
    private List<Flight> flightsList;


    public User(Long id, String username, String firstName, String lastName, String email, String password, List<Flight> flightsList) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
<<<<<<< HEAD

=======
        this.flightsList = flightsList;
>>>>>>> 05bb174aa9342cc57e94181ccb616b912c2af38a
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
<<<<<<< HEAD

=======
>>>>>>> 05bb174aa9342cc57e94181ccb616b912c2af38a
        this.password = copy.password;
        this.flightsList = copy.flightsList;
    }

    public User() {
    }

    public String getUsername() {
        return username;
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


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Flight> getFlightsList() {
        return this.flightsList;
    }

    public void setFlightsList(List<Flight> flightsList) {
        this.flightsList = flightsList;
    }
}
