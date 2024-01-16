package com.example.hotelbookingapp.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Booking {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull(message = "User ID cannot be null")
private Long userId;

@ManyToOne
@JoinColumn(name = "hotel_id", nullable = false)
private Hotel hotel;

@NotNull(message = "Check-in date cannot be null")
private LocalDate checkInDate;

@NotNull(message = "Check-out date cannot be null")
private LocalDate checkOutDate;

@NotNull(message = "Number of guests cannot be null")
@Min(value = 1, message = "Number of guests must be at least 1")
private Integer numberOfGuests;

// Constructors

public Booking() {
// Default constructor
}

public Booking(Long userId, Hotel hotel, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfGuests) {
this.userId = userId;
this.hotel = hotel;
this.checkInDate = checkInDate;
this.checkOutDate = checkOutDate;
this.numberOfGuests = numberOfGuests;
}

// Getters and setters

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public Long getUserId() {
return userId;
}

public void setUserId(Long userId) {
this.userId = userId;
}

public Hotel getHotel() {
return hotel;
}

public void setHotel(Hotel hotel) {
this.hotel = hotel;
}

public LocalDate getCheckInDate() {
return checkInDate;
}

public void setCheckInDate(LocalDate checkInDate) {
this.checkInDate = checkInDate;
}

public LocalDate getCheckOutDate() {
return checkOutDate;
}

public void setCheckOutDate(LocalDate checkOutDate) {
this.checkOutDate = checkOutDate;
}

public Integer getNumberOfGuests() {
return numberOfGuests;
}

public void setNumberOfGuests(Integer numberOfGuests) {
this.numberOfGuests = numberOfGuests;
}

// toString, hashCode, and equals methods

@Override
public String toString() {
return "Booking{" +
"id=" + id +
", userId=" + userId +
", hotel=" + hotel +
", checkInDate=" + checkInDate +
", checkOutDate=" + checkOutDate +
", numberOfGuests=" + numberOfGuests +
'}';
}

@Override
public int hashCode() {
return Objects.hash(id, userId, hotel, checkInDate, checkOutDate, numberOfGuests);
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Booking booking = (Booking) o;
return Objects.equals(id, booking.id) &&
Objects.equals(userId, booking.userId) &&
Objects.equals(hotel, booking.hotel) &&
Objects.equals(checkInDate, booking.checkInDate) &&
Objects.equals(checkOutDate, booking.checkOutDate) &&
Objects.equals(numberOfGuests, booking.numberOfGuests);
}
}
