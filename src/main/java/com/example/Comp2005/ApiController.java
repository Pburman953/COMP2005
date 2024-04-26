package com.example.Comp2005;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
@Component
public class ApiController{

    private final RestTemplate restTemplate;

    public String apiURL = "https://web.socem.plymouth.ac.uk/COMP2005/api";

    @Autowired
    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




    public String fetchDataFromExternalApi(String requestExt) throws IOException {
        String requestUrl = apiURL + requestExt;
        URL apiUrl = new URL(requestUrl);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response body
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        connection.disconnect();
        System.out.println(response);
        return response.toString();
    }
}
