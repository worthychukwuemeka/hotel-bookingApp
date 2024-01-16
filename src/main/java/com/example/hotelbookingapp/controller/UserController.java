package com.example.hotelbookingapp.controller;

import com.example.hotelbookingapp.model.User;
import com.example.hotelbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if (userService.loginUser(user)) {
            return ResponseEntity.ok("User logged in successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }
}


