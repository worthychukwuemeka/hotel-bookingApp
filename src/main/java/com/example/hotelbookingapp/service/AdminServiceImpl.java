package com.example.hotelbookingapp.service;
// AdminServiceImpl.java
import com.example.hotelbookingapp.repository.BookingRepository;
import com.example.hotelbookingapp.repository.HotelRepository;
import com.example.hotelbookingapp.repository.RoomRepository;
import com.example.hotelbookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AdminServiceImpl implements AdminService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

}
