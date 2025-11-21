package com.group13.roombookingsystem.model.room;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Room {
    private String roomName;
    private int capacity;
    private String location;
    private boolean hasProjector;
    private boolean hasSpeakers;
    private boolean isEnabled;
    private ArrayList<LocalDateTime> schedule;

     // link database ID to room
    private int DatabaseId;

    public int getRoomID() {
        return DatabaseId;
    }

    public void setRoomId(int id) {
        this.DatabaseId = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public boolean getHasProjector() {
        return hasProjector;
    }

    public boolean getHasSpeakers() {
        return hasSpeakers;
    }

    void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    void setLocation(String location) {
        this.location = location;
    }

    void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    void setHasSpeakers(boolean hasSpeakers) {
        this.hasSpeakers = hasSpeakers;
    }
}
