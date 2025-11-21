package com.group13.roombookingsystem.model.user;

public class Staff extends User {
    public static final int HOURLY_RATE = 40;

    public Staff(String email, String password, String role, boolean verified) {
        super(email, password, "Staff", verified);
        setHourlyRate(HOURLY_RATE);
    }
}
