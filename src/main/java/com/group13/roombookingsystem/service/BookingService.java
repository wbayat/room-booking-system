package com.group13.roombookingsystem.service;

import java.util.ArrayList;

import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.UserRepository;
import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.repository.BookingRepository;

public class BookingService {
    private static BookingService instance;
    private final BookingRepository bookingRepository = new BookingRepository();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }
}
