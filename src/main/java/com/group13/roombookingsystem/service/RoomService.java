package com.group13.roombookingsystem.service;
import java.util.ArrayList;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.UserRepository;
import com.group13.roombookingsystem.repository.RoomRepository;

public class RoomService {

    private static RoomService instance;
    private final RoomRepository roomRepository = new RoomRepository();
    private ArrayList<Room> rooms = new ArrayList<>();

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }
}
