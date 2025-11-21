package com.group13.roombookingsystem.model.user.university;

import com.group13.roombookingsystem.model.user.User;

public class Student extends User {
    public static final int HOURLY_RATE = 20;

    public Student() {
        super(null, null, null, "Student", false, HOURLY_RATE);
    }

    public Student(Integer id, String username, String password, boolean verified) {
        super(id, username, password, "Student", verified, HOURLY_RATE);
    }

    public Student(String username, String password, boolean verified) {
        this(null, username, password, verified);
    }
}
