package com.sk.dev.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);
            return root.path("url").asText();  // extract "url" field from JSON
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // or return some default image URL
        }
    }
}
