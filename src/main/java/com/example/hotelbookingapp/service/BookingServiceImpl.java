package com.example.hotelbookingapp.service;

// BookingServiceImpl.java
import com.example.hotelbookingapp.model.Booking;
import com.example.hotelbookingapp.model.Hotel;
import com.example.hotelbookingapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Hotel> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Hotel getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    @Override
    public Booking createBooking(Booking booking) {
        // Add any additional validation or business logic before saving
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        // Check if the booking with the given id exists
        Booking existingBooking = getBookingById(id);

        // Update the existing booking
        existingBooking.setUserId(booking.getUserId());
        existingBooking.setHotel(booking.getHotel());
        existingBooking.setCheckInDate(booking.getCheckInDate());
        existingBooking.setCheckOutDate(booking.getCheckOutDate());
        existingBooking.setNumberOfGuests(booking.getNumberOfGuests());

        // Save the updated booking
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

