package com.group13.roombookingsystem.model.user;

public class Student extends User {
    public static final int HOURLY_RATE = 20;

    public Student(String email, String password, String role, boolean verified) {
        super(email, password, "Student", verified);
        setHourlyRate(HOURLY_RATE);
    }

}
