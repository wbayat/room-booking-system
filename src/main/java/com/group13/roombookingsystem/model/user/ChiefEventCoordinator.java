package com.group13.roombookingsystem.model.user;

public class ChiefEventCoordinator extends Admin {
    public static final int HOURLY_RATE = Admin.HOURLY_RATE;

    public ChiefEventCoordinator() {
        super("chief@gmail.com", "chiefPassword", "ChiefEventCoordinator", true);
        setHourlyRate(HOURLY_RATE);
    }
}
