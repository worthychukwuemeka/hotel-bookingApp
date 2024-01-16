package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Hotel, Long> {

}
