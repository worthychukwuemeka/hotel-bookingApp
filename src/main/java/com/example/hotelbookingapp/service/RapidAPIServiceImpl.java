package com.example.hotelbookingapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RapidAPIServiceImpl implements RapidAPIService {

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @Override
    public String getRapidAPIMetaData() {
        try {
            URI uri = UriComponentsBuilder.fromHttpUrl("https://hotels4.p.rapidapi.com/v2/get-meta-data")
                    .build().toUri();

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", rapidApiKey);
            headers.set("X-RapidAPI-Host", rapidApiHost);

            RequestEntity<Void> requestEntity = RequestEntity.get(uri).headers(headers).build();

            ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            } else {
                throw new RuntimeException("Error fetching RapidAPI Meta Data. Status code: " + responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error fetching RapidAPI Meta Data. Status code: " + e.getRawStatusCode(), e);
        }
    }
}
