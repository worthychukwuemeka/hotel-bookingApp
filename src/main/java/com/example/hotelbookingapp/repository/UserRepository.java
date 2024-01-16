package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Hotel, Long> {

}
