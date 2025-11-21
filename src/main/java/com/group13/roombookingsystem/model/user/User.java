package com.group13.roombookingsystem.model.user;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private boolean verified;
    private int hourlyRate;

    public User(String username, String password, String role, boolean verified) {
        this(null, username, password, role, verified, 0);
    }

    public User(Integer id, String username, String password, String role, boolean verified, int hourlyRate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.verified = verified;
        this.hourlyRate = hourlyRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerifiedValue() {
        return verified ? 1 : 0;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
