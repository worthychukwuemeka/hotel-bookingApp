package com.example.hotelbookingapp.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Room {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "hotel_id", nullable = false)
private Hotel hotel;

@NotEmpty(message = "Room number cannot be empty")
private String roomNumber;

// Additional fields as needed

// Constructors

public Room() {
// Default constructor
}

public Room(Hotel hotel, String roomNumber) {
this.hotel = hotel;
this.roomNumber = roomNumber;
}

// Getters and setters

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public Hotel getHotel() {
return hotel;
}

public void setHotel(Hotel hotel) {
this.hotel = hotel;
}

public String getRoomNumber() {
return roomNumber;
}

public void setRoomNumber(String roomNumber) {
this.roomNumber = roomNumber;
}

// toString, hashCode, and equals methods

@Override
public String toString() {
return "Room{" +
"id=" + id +
", hotel=" + hotel +
", roomNumber='" + roomNumber + '\'' +
'}';
}

@Override
public int hashCode() {
return Objects.hash(id, hotel, roomNumber);
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Room room = (Room) o;
return Objects.equals(id, room.id) &&
Objects.equals(hotel, room.hotel) &&
Objects.equals(roomNumber, room.roomNumber);
}
}
