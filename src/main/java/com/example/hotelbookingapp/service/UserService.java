package com.example.hotelbookingapp.service;

// UserService.java
import com.example.hotelbookingapp.model.Hotel;
import com.example.hotelbookingapp.model.User;

import java.util.List;

public interface UserService {

    List<Hotel> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    void registerUser(User user);

    boolean loginUser(User user);
}
