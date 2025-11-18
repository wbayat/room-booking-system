package com.group13.roombookingsystem.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found.");
    }
}
