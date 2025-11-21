package com.group13.roombookingsystem.model.user.university;

import com.group13.roombookingsystem.model.user.User;

public class Faculty extends User {
    public static final int HOURLY_RATE = 30;

    public Faculty(Integer id, String username, String password, boolean verified) {
        super(id, username, password, "Faculty", false, HOURLY_RATE);
    }

    public int getHourlyRate() {
        return HOURLY_RATE;
    }

}
