package com.group13.roombookingsystem.model.user;

public class ChiefEventCoordinator extends Admin {
    public static final int HOURLY_RATE = Admin.HOURLY_RATE;

    public ChiefEventCoordinator(String string, String string1, String chiefEventCoordinator, boolean verified) {
        super("chief@gmail.com", "chiefPassword", "ChiefEventCoordinator", true);
        setHourlyRate(HOURLY_RATE);
    }
}
