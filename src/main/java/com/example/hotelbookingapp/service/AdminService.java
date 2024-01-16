package com.example.hotelbookingapp.service;

// AdminService.java
import com.example.hotelbookingapp.model.Booking;
import com.example.hotelbookingapp.model.Hotel;
import com.example.hotelbookingapp.model.Room;
import com.example.hotelbookingapp.model.User;

import java.util.List;

public interface AdminService {

    // Get a list of all hotels
    List<Hotel> getAllHotels();

    // Get details of a specific hotel
    Hotel getHotelById(Long id);

    // Create a new hotel
    Hotel createHotel(Hotel hotel);

    // Update an existing hotel
    Hotel updateHotel(Long id, Hotel hotel);

    // Delete a hotel by its ID
    void deleteHotel(Long id);

    // Get a list of all rooms
    List<Room> getAllRooms();

    // Get details of a specific room
    Room getRoomById(Long id);

    // Create a new room
    Room createRoom(Room room);

    // Update an existing room
    Room updateRoom(Long id, Room room);

    // Delete a room by its ID
    void deleteRoom(Long id);

    // Get a list of all bookings
    List<Booking> getAllBookings();

    // Get details of a specific booking
    Booking getBookingById(Long id);

    // Update an existing booking
    Booking updateBooking(Long id, Booking booking);

    // Delete a booking by its ID
    void deleteBooking(Long id);

    // Get a list of all users
    List<User> getAllUsers();

    // Get details of a specific user
    User getUserById(Long id);

    // Delete a user by their ID
    void deleteUser(Long id);
}
