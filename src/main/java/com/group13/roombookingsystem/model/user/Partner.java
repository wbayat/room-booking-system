package com.group13.roombookingsystem.model.user;

public class Partner extends User {
    public static final int HOURLY_RATE = 50;

    public Partner(Integer id, String username, String password, boolean verified) {
        super(id, username, password, "Partner", true, HOURLY_RATE);
    }

    public int getHourlyRate() {
        return HOURLY_RATE;
    }
}
