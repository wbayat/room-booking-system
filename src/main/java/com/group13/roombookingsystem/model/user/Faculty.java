package com.group13.roombookingsystem.model.user;

public class Faculty extends User {
    public static final int HOURLY_RATE = 30;

    public Faculty(String email, String password, int identification, String role, boolean verified) {
        super(email, password, identification, "Faculty", verified);
        setHourlyRate(HOURLY_RATE);
    }

}
