package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.exception.UserNotFoundException;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    // Singleton instance
    private static UserService instance;
    private final UserRepository userRepository = new UserRepository();
    private ArrayList<User> users = new ArrayList<>();

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User login(String email, String password) throws UserNotFoundException {
        User user = userRepository.findByUsername(email).orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException();
        }

        return user;
    }

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User with that username already exists.");
        }
        
        if (user.getRole() == null || user.getRole().isBlank()) {
            throw new IllegalArgumentException("Role must be provided.");
        }
        
        user.setVerified("admin".equalsIgnoreCase(user.getRole()));
        return userRepository.create(user);
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findByUsername(email).orElseThrow(UserNotFoundException::new);
    }

    public User createAdmin(User admin) {
        admin.setRole("admin");
        admin.setVerified(true);
        return registerUser(admin);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByVerification(boolean verified) {
        return userRepository.findByVerification(verified);
    }

    public void setUserVerified(int userId, boolean verified) {
        userRepository.updateVerification(userId, verified);
    }

    
}
