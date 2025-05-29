package com.sk.dev.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpaceFacts {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${nasa.api.key}")
    private String nasaApiKey;

    public String getAstronomyPictureOfDay() {
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + nasaApiKey;
        return restTemplate.getForObject(url, String.class);
    }
}
