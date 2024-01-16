package com.example.hotelbookingapp.controller;

import com.example.hotelbookingapp.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoritesController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToFavorites(@RequestParam Long hotelId) {
        // Add the hotel ID to the set of favorites using the service
        boolean added = favoriteService.addToFavorites(hotelId);

        if (added) {
            return ResponseEntity.ok("Hotel added to favorites");
        } else {
            return ResponseEntity.badRequest().body("Hotel is already in favorites");
        }
    }
}
