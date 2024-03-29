package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(Long id, Hotel hotel);

    void deleteHotel(Long id);
}
