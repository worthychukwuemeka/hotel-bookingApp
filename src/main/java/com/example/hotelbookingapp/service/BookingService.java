package com.example.hotelbookingapp.service;

// BookingService.java
import com.example.hotelbookingapp.model.Booking;
import com.example.hotelbookingapp.model.Hotel;

import java.util.List;

public interface BookingService {

    List<Hotel> getAllBookings();

    Hotel getBookingById(Long id);

    Booking createBooking(Booking booking);

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long id);
}

