package com.group13.roombookingsystem.model.user;

public class Admin extends Staff {
    public static final int HOURLY_RATE = Staff.HOURLY_RATE;

    public Admin(String email, String password, int identification, String role, boolean verified) {
        super(email, password, identification, "Admin", verified);
        setHourlyRate(HOURLY_RATE);
    }

    @Override
    public void setVerified(boolean verified) {
        super.setVerified(true);
    }
}
