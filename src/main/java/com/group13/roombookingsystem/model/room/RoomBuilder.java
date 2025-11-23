package com.group13.roombookingsystem.model.room;

interface RoomBuilderContract {
    void reset();
    void setRoomID(int roomId);
    void setRoomName(String roomName);
    void setCapacity(int capacity);
    void setLocation(String location);
    void setEnabled(boolean enabled);
    void setHasProjector(boolean hasProjector);
    void setHasSpeakers(boolean hasSpeakers);
    void setSchedule(java.util.ArrayList<java.time.LocalDateTime> schedule);
    void setSensorId(int sensorId); // added for sensor ID
}

public class RoomBuilder implements RoomBuilderContract {
    private Room result;

    @Override
    public void reset() {
        result = new Room();
    }

    @Override
    public void setRoomName(String roomName) {
        result.setRoomName(roomName);
    }

    @Override
    public void setCapacity(int capacity) {
        result.setCapacity(capacity);
    }

    @Override
    public void setLocation(String location) {
        result.setLocation(location);
    }

    @Override
    public void setEnabled(boolean enabled) {
        result.setEnabled(enabled);
    }

    @Override
    public void setHasProjector(boolean hasProjector) {
        result.setHasProjector(hasProjector);
    }

    @Override
    public void setHasSpeakers(boolean hasSpeakers) {
        result.setHasSpeakers(hasSpeakers);
    }

    @Override
    public void setRoomID(int roomId) {
        result.setRoomId(roomId);
    }

    public Room getProduct() {
        Room built = result;
        reset();
        return built;
    }

    @Override
    public void setSchedule(java.util.ArrayList<java.time.LocalDateTime> schedule) {
        result.setSchedule(schedule);
    }

    @Override
    public void setSensorId(int sensorId) {
        result.setSensorId(sensorId);
    }
}
