package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.model.Hotel;  // Import the Hotel class
import com.example.hotelbookingapp.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        // Add any additional validation or business logic before saving
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        // Check if the hotel with the given id exists
        Hotel existingHotel = getHotelById(id);

        // Update the existing hotel
        existingHotel.setAddress(hotel.getAddress());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setCountry(hotel.getCountry());
        existingHotel.setPostalCode(hotel.getPostalCode());
        existingHotel.setPhoneNumber(hotel.getPhoneNumber());
        existingHotel.setWebsite(hotel.getWebsite());
        existingHotel.setStarRating(hotel.getStarRating());

        // Save the updated hotel
        return hotelRepository.save(existingHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}

