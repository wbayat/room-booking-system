package com.group13.roombookingsystem.model.user;

import java.util.ArrayList;

import com.group13.roombookingsystem.model.booking.Booking;

public class User {
    private String email;
    private String password;
    private String role;
    private boolean verified;
    private int hourlyRate;
    private int identification;

    private ArrayList<Booking> bookings;

    public User(String email, String password, int identification, String role, boolean verified) {
        this.email = email;
        this.password = password;
        this.identification = identification;
        this.role = role;
        this.verified = verified;
    }

    // only for linking database and cardControllers
    private int DatabaseId;

    public int getId() {
        return DatabaseId;
    }
    public void setId(int id) {
        this.DatabaseId = id;
    }

    // i wanna change this to getEmail but userService uses username soooo 
    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isVerified() {
        return verified;
    }

    public int getVerifiedValue() {
        return verified ? 1 : 0;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getVerificationNumber() {
        return identification;
    }

    public void setVerificationNumber(int identification) {
        this.identification = identification;
    }

    public void addBooking(Booking b) {
        bookings.add(b);
    }

    public void removeBooking(Booking b) {

        for(Booking b1 : bookings) {
            if(b.getBookingID() == b1.getBookingID()) {
                bookings.remove(b);
            }
        }

    }
}
