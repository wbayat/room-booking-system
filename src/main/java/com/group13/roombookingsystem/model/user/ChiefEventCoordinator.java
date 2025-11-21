package com.group13.roombookingsystem.model.user;

public class ChiefEventCoordinator extends Admin {
    public static final int HOURLY_RATE = Admin.HOURLY_RATE;

    public ChiefEventCoordinator(String email, String password, int identification, String role, boolean verified) {
        super("chief@yorku.ca", "123", 0001, "ChiefEventCoordinator", true);
        setHourlyRate(HOURLY_RATE);
    }
}
