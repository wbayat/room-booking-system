package com.group13.roombookingsystem.model.room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Room {
    private Integer id;
    private final String name;
    private final int capacity;
    private final String location;
    private final String description;
    private final boolean enabled;
    private final List<String> amenities;

    private Room(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.capacity = builder.capacity;
        this.location = builder.location;
        this.description = builder.description;
        this.enabled = builder.enabled;
        this.amenities = List.copyOf(builder.amenities);
    }

    public static Builder builder(String name, int capacity) {
        return new Builder(name, capacity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return capacity == room.capacity
                && enabled == room.enabled
                && Objects.equals(id, room.id)
                && Objects.equals(name, room.name)
                && Objects.equals(location, room.location)
                && Objects.equals(description, room.description)
                && Objects.equals(amenities, room.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, location, description, enabled, amenities);
    }

    public static final class Builder {
        private Integer id;
        private final String name;
        private final int capacity;
        private String location = "";
        private String description = "";
        private boolean enabled = true;
        private final List<String> amenities = new ArrayList<>();

        private Builder(String name, int capacity) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Room name cannot be blank.");
            }
            if (capacity <= 0) {
                throw new IllegalArgumentException("Room capacity must be positive.");
            }
            this.name = name;
            this.capacity = capacity;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder locatedAt(String location) {
            this.location = location == null ? "" : location;
            return this;
        }

        public Builder describedAs(String description) {
            this.description = description == null ? "" : description;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder amenities(List<String> amenities) {
            this.amenities.clear();
            if (amenities != null) {
                this.amenities.addAll(amenities);
            }
            return this;
        }

        public Builder addAmenity(String amenity) {
            if (amenity != null && !amenity.isBlank()) {
                this.amenities.add(amenity);
            }
            return this;
        }

        public Room build() {
            return new Room(this);
        }

        public List<String> getAmenities() {
            return Collections.unmodifiableList(amenities);
        }
    }
}
