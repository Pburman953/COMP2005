package com.example.Comp2005;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public maternityAPIService maternityAPIService(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        return new maternityAPIService(restTemplate, apiUrl);
    }
}
