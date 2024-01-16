package com.example.hotelbookingapp.service;

// BookingService.java
import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking createBooking(Booking booking);

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long id);
}

