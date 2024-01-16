package com.example.hotelbookingapp.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty(message = "Name cannot be empty")
private String name;

@Email(message = "Please provide a valid email address")
private String email;

@NotNull(message = "Age cannot be null")
@Min(value = 0, message = "Age cannot be negative")
private Integer age;

@NotNull(message = "Check-in date cannot be null")
private LocalDate checkInDate;

@NotNull(message = "Check-out date cannot be null")
private LocalDate checkOutDate;

@NotNull(message = "Number of guests cannot be null")
@Min(value = 1, message = "Number of guests must be at least 1")
private Integer numberOfGuests;

// Constructors

public User() {
// Default constructor
}

public User(String name, String email, Integer age, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfGuests) {
this.name = name;
this.email = email;
this.age = age;
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

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
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
return "User{" +
"id=" + id +
", name='" + name + '\'' +
", email='" + email + '\'' +
", age=" + age +
", checkInDate=" + checkInDate +
", checkOutDate=" + checkOutDate +
", numberOfGuests=" + numberOfGuests +
'}';
}

@Override
public int hashCode() {
return Objects.hash(id, name, email, age, checkInDate, checkOutDate, numberOfGuests);
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
User user = (User) o;
return age == user.age &&
Objects.equals(id, user.id) &&
Objects.equals(name, user.name) &&
Objects.equals(email, user.email) &&
Objects.equals(checkInDate, user.checkInDate) &&
Objects.equals(checkOutDate, user.checkOutDate) &&
Objects.equals(numberOfGuests, user.numberOfGuests);
}
}
