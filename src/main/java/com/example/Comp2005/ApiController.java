package com.example.Comp2005;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ApiController{

    private final RestTemplate restTemplate;

    @Autowired
    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public String fetchDataFromApi(String requestUrl) {
        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);
        System.out.println("Fetched data from API: " + response);

        return response.getBody();
    }
}
