package com.example.hotelbookingapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/rapid-api")
public class RapidAPIController {

    private static final String RAPID_API_URL = "https://hotels4.p.rapidapi.com/v2/get-meta-data";
    private static final String RAPID_API_KEY = "99d0212a21msh46947314d394445p1d8ad7jsnd56ecbd33283";
    private static final String RAPID_API_HOST = "hotels4.p.rapidapi.com";

    @GetMapping("/get-meta-data")
    public ResponseEntity<String> getRapidAPIMetaData() {
        try {
            // Create the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(RAPID_API_URL))
                    .header("X-RapidAPI-Key", RAPID_API_KEY)
                    .header("X-RapidAPI-Host", RAPID_API_HOST)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            // Send the request and get the response
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Return the response body
            return ResponseEntity.ok(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions and return an appropriate response
            return ResponseEntity.status(500).body("Error fetching RapidAPI Meta Data");
        }
    }
}
