package com.example.Comp2005;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
public class maternityAPIService {

    private final RestTemplate restTemplate;
    private final String apiUrl; // Base URL of the external API

    public maternityAPIService(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }


    /*
    public List<Admission> getAdmissionsForPatient(Long patientId) {
        String url = apiUrl + "/admissions/{patientId}";
        return restTemplate.getForObject(url, List.class, patientId);
    }

    // Implement other methods for other API endpoints

    */

}

