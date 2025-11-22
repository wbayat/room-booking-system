package com.group13.roombookingsystem.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.group13.roombookingsystem.model.room.*;
import com.group13.roombookingsystem.repository.RoomRepository;
import com.group13.roombookingsystem.service.observer.RoomPublisher;

public class RoomService extends RoomPublisher {

    private static RoomService instance;
    private final RoomRepository roomRepository = new RoomRepository();
    private List<Room> rooms = new ArrayList<>();
    private RoomBuilder roomBuilder = new RoomBuilder();

    private RoomService(){
        super();
    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
            instance.init();
        }
        return instance;
    }

    private void init(){
        rooms = roomRepository.findAll();
    }

    public void addRoom(String roomName, int capacity, String location, boolean hasProjector, boolean hasSpeakers, ArrayList<LocalDateTime> schedule, int sensorId) {
        this.roomBuilder.reset();
        this.roomBuilder.setRoomName(roomName);
        this.roomBuilder.setCapacity(capacity);
        this.roomBuilder.setLocation(location);
        this.roomBuilder.setHasProjector(hasProjector);
        this.roomBuilder.setHasSpeakers(hasSpeakers);
        this.roomBuilder.setSchedule(schedule);
        this.roomBuilder.setSensorId(sensorId);

        
        Room room = this.roomBuilder.getProduct();
        rooms.add(room);
        roomRepository.create(room);
        this.notifyUpdate();
    }

    public void disableRoom(Room room) {
        room.setDisabled(true); // Assuming Room has a setDisabled method
        roomRepository.update(room); // Assuming RoomRepository has an update method
        this.notifyUpdate();
    }

    public List<Room> getRooms() {
        return rooms;
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
