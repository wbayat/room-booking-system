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
    private int sensorId; // sensor ID for IoT integration for sensor class

     // link database ID to room
    private int DatabaseId;

    public int getRoomID() {
        return DatabaseId;
    }

    public void setRoomId(int id) {
        this.DatabaseId = id;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
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

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public void setHasSpeakers(boolean hasSpeakers) {
        this.hasSpeakers = hasSpeakers;
    }

    // add to support RoomService.disableRoom(Room)
    public void setDisabled(boolean disabled) {
        this.isEnabled = !disabled;
    }
    // add for schedule parameter recently introduced
    public ArrayList<LocalDateTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<LocalDateTime> schedule) {
        this.schedule = schedule;
    }
}
