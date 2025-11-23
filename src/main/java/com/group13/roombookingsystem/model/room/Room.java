package com.group13.roombookingsystem.model.room;

import com.group13.roombookingsystem.model.sensor.Sensor;

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
    private Sensor sensor;

     // link database ID to room
    private int DatabaseId;

    public int getRoomID() {
        return DatabaseId;
    }

    public void setRoomId(int id) {
        this.DatabaseId = id;
    }

    public int getSensorId() {
        return sensor.getSensorID();
    }

    public void setSensorId(int id) {
        sensor.setSensorID(id);
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    // add for schedule parameter recently introduced
    public ArrayList<LocalDateTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<LocalDateTime> schedule) {
        this.schedule = schedule;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
