package com.example.hotelbookingapp.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final Set<Long> favoriteHotelIds = new HashSet<>(); // Store favorite hotel IDs (in-memory, replace with a database)

    @Override
    public boolean addToFavorites(Long hotelId) {
        return favoriteHotelIds.add(hotelId);
    }
}
