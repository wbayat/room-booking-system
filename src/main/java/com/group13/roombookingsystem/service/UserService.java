package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.exception.UserNotFoundException;
import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.model.user.ChiefEventCoordinator;
import com.group13.roombookingsystem.model.user.Faculty;
import com.group13.roombookingsystem.model.user.Partner;
import com.group13.roombookingsystem.model.user.Staff;
import com.group13.roombookingsystem.model.user.Student;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.UserRepository;
import com.group13.roombookingsystem.utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    // Singleton instance
    private static UserService instance;
    private final UserRepository userRepository = new UserRepository();
    private List<User> users = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
            instance.init();
        }
        return instance;
    }

    private void init(){
        users = userRepository.findAll();
        for (User user : users){
            if (user.getRole().equals("Admin")){
                admins.add((Admin) user);
            }
        }
    }

    public List<Admin> getAdmins(){
        return admins;
    }

    public User login(String email, String password) throws UserNotFoundException {
        String normalizedEmail = email == null ? "" : email.trim();
        User user = userRepository.findByUsername(normalizedEmail).orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public User registerUser(String email, String password, int identification, String role, boolean verified) {
        String normalizedEmail = email == null ? null : email.trim();

        if (!ValidationUtils.isValidEmail(normalizedEmail)) {
            throw new IllegalArgumentException("Email address is invalid.");
        }

        if (!ValidationUtils.isValidPassword(password)) {
            throw new IllegalArgumentException("Password does not meet security requirements.");
        }

        User user = new User(normalizedEmail, password, identification, role, verified);
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User with that username already exists.");
        }
        
        if (user.getRole() == null || user.getRole().isBlank()) {
            throw new IllegalArgumentException("Role must be provided.");
        }
        
        user.setVerified("admin".equalsIgnoreCase(user.getRole()));
        this.users.add(user);
        return userRepository.create(user);
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findByUsername(email).orElseThrow(UserNotFoundException::new);
    }

    public User createAdmin(String email, String password, int identification) throws UserNotFoundException {
        registerUser(email, password, identification, "Admin", true);
        User admin = login(email, password);
        this.admins.add((Admin) admin);
        return admin;
    }

    public List<User> getUnverifiedUsers() {
        return userRepository.findByVerification(false);
    }

    //Methods migrated: delegate to UserRepository
    public User create(User user) {
        return userRepository.create(user);
    }

    public void updateVerification(int userId, boolean verified) {
        userRepository.updateVerification(userId, verified);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByVerification(boolean verified) {
        return userRepository.findByVerification(verified);
    }

    //Auto-generated getters and setters
    public List<User> getUsers() {
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
