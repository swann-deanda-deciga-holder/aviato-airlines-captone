package com.aviato.demo.models;

public class Admin {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean canAddFlights;
    private boolean canEditFlights;
    private boolean canDeleteFlights;
    private boolean canManageUsers;

    public Admin(String username, String password, String email, String firstName, String lastName, boolean canAddFlights, boolean canEditFlights, boolean canDeleteFlights, boolean canManageUsers) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.canAddFlights = canAddFlights;
        this.canEditFlights = canEditFlights;
        this.canDeleteFlights = canDeleteFlights;
        this.canManageUsers = canManageUsers;
    }

    // getters and setters for all fields

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isCanAddFlights() {
        return canAddFlights;
    }

    public void setCanAddFlights(boolean canAddFlights) {
        this.canAddFlights = canAddFlights;
    }

    public boolean isCanEditFlights() {
        return canEditFlights;
    }

    public void setCanEditFlights(boolean canEditFlights) {
        this.canEditFlights = canEditFlights;
    }

    public boolean isCanDeleteFlights() {
        return canDeleteFlights;
    }

    public void setCanDeleteFlights(boolean canDeleteFlights) {
        this.canDeleteFlights = canDeleteFlights;
    }

    public boolean isCanManageUsers() {
        return canManageUsers;
    }

    public void setCanManageUsers(boolean canManageUsers) {
        this.canManageUsers = canManageUsers;
    }
}