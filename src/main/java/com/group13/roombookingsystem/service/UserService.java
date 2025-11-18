package com.group13.roombookingsystem.service;
import java.util.ArrayList;

import com.group13.roombookingsystem.exception.UserNotFoundException;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;

public class UserService {
    private ArrayList<Room> users = new ArrayList<>();

    public User login(String email, String password) throws UserNotFoundException {
        return null;
    }

    public User registerUser(User user){
        return null;
    }

    public User getUserByEmail(String email) throws UserNotFoundException{
        return null;
    }

    public User getUserById(int userId) throws UserNotFoundException{
        return null;
    }

    public User createAdmin(User admin){
        return null;
    }

    public ArrayList<Room> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Room> users) {
        this.users = users;
    }
}
