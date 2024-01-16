package com.example.hotelbookingapp.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Hotel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty(message = "Name cannot be empty")
private String name;

@NotEmpty(message = "Address cannot be empty")
private String address;

@NotEmpty(message = "City cannot be empty")
private String city;

private String country;

@NotEmpty(message = "Postal Code cannot be empty")
private String postalCode;

private String phoneNumber;

private String website;

private int starRating; // Example: 1 to 5

// Constructors

public Hotel() {
// Default constructor
}

public Hotel(String name, String address, String city, String country, String postalCode,
String phoneNumber, String website, int starRating) {
this.name = name;
this.address = address;
this.city = city;
this.country = country;
this.postalCode = postalCode;
this.phoneNumber = phoneNumber;
this.website = website;
this.starRating = starRating;
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

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getPostalCode() {
return postalCode;
}

public void setPostalCode(String postalCode) {
this.postalCode = postalCode;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public int getStarRating() {
return starRating;
}

public void setStarRating(int starRating) {
this.starRating = starRating;
}

// toString, hashCode, and equals methods

@Override
public String toString() {
return "Hotel{" +
"id=" + id +
", name='" + name + '\'' +
", address='" + address + '\'' +
", city='" + city + '\'' +
", country='" + country + '\'' +
", postalCode='" + postalCode + '\'' +
", phoneNumber='" + phoneNumber + '\'' +
", website='" + website + '\'' +
", starRating=" + starRating +
'}';
}

@Override
public int hashCode() {
return Objects.hash(id, name, address, city, country, postalCode, phoneNumber, website, starRating);
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Hotel hotel = (Hotel) o;
return starRating == hotel.starRating &&
Objects.equals(id, hotel.id) &&
Objects.equals(name, hotel.name) &&
Objects.equals(address, hotel.address) &&
Objects.equals(city, hotel.city) &&
Objects.equals(country, hotel.country) &&
Objects.equals(postalCode, hotel.postalCode) &&
Objects.equals(phoneNumber, hotel.phoneNumber) &&
Objects.equals(website, hotel.website);
}
}
