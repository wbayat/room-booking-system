package com.group13.roombookingsystem.model.user.university;

import com.group13.roombookingsystem.model.user.User;

public class Staff extends User {
    public static final int HOURLY_RATE = 40;

    public Staff(Integer id, String username, String password, boolean verified) {
        this(id, username, password, "Staff", verified, HOURLY_RATE);
    }

    protected Staff(Integer id, String username, String password, String role, boolean verified, int hourlyRate) {
        super(id, username, password, role, verified, hourlyRate);
    }

    public int getHourlyRate() {
        return HOURLY_RATE;
    }
}
