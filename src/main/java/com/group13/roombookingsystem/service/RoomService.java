package com.group13.roombookingsystem.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.group13.roombookingsystem.model.room.*;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.UserRepository;
import com.group13.roombookingsystem.repository.RoomRepository;

public class RoomService {

    private static RoomService instance;
    private final RoomRepository roomRepository = new RoomRepository();
    private ArrayList<Room> rooms = new ArrayList<>();
    private RoomBuilder roomBuilder = new RoomBuilder();

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public void addRoom(String roomName, int capacity, String location, boolean hasProjector, boolean hasSpeakers, ArrayList<LocalDateTime> schedule) {
        
        this.roomBuilder.setRoomName(roomName);
        this.roomBuilder.setCapacity(capacity);
        this.roomBuilder.setLocation(location);
        this.roomBuilder.setHasProjector(hasProjector);
        this.roomBuilder.setHasSpeakers(hasSpeakers);
        this.roomBuilder.setSchedule(schedule); //Schedule does not currently compile as it is missing in Roombuilder

        
        Room room = this.roomBuilder.getProduct();
        rooms.add(room);
        roomRepository.create(room);
    }

    public void disableRoom(Room room) {
        room.setDisabled(true); // Assuming Room has a setDisabled method
        roomRepository.update(room); // Assuming RoomRepository has an update method
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void modifyRoom(Room room, String newRoomName, int newCapacity, String newLocation, boolean newHasProjector, boolean newHasSpeakers) {
        room.setRoomName(newRoomName);
        room.setCapacity(newCapacity);
        room.setLocation(newLocation);
        room.setHasProjector(newHasProjector);
        room.setHasSpeakers(newHasSpeakers);
        roomRepository.update(room); // Assuming RoomRepository has an update method
    }

}
