package com.example.hotelbookingapp.service;

// UserServiceImpl.java
import com.example.hotelbookingapp.model.Hotel;
import com.example.hotelbookingapp.model.User;
import com.example.hotelbookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Hotel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        // Add any additional validation or business logic before saving
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        // Check if the user with the given id exists
        User existingUser = getUserById(id);

        // Update the existing user
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        existingUser.setCheckInDate(user.getCheckInDate());
        existingUser.setCheckOutDate(user.getCheckOutDate());
        existingUser.setNumberOfGuests(user.getNumberOfGuests());

        // Save the updated user
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

