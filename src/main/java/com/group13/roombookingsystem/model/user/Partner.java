package com.group13.roombookingsystem.model.user;

public class Partner extends User {
    public static final int HOURLY_RATE = 50;

    public Partner(String email, String password, String role, boolean verified) {
        super(email, password, "Partner", true);
        setHourlyRate(HOURLY_RATE);
    }

    @Override
    public void setVerified(boolean verified) {
        super.setVerified(true);
    }
}
