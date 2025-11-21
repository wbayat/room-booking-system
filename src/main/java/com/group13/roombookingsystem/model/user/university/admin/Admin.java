package com.group13.roombookingsystem.model.user.university.admin;

import com.group13.roombookingsystem.model.user.university.Staff;

public class Admin extends Staff {
    public static final int HOURLY_RATE = Staff.HOURLY_RATE;

    public Admin(Integer id, String username, String password, boolean verified) {
        super(id, username, password, "Admin", verified, HOURLY_RATE);
    }

    // constructor for the ChiefEventCoordinator
    protected Admin(Integer id, String username, String password, String role, boolean verified, int hourlyRate) {
        super(id, username, password, role, verified, hourlyRate);
    }

}
