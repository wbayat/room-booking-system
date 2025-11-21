package com.group13.roombookingsystem.model.user;

public class User {
    private String email;
    private String password;
    private String role;
    private boolean verified;
    private int hourlyRate;

    public User(String email, String password, String role, boolean verified) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.verified = verified;
    }

    // only for linking database and cardControllers
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
