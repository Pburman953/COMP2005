package com.example.Comp2005;

import com.example.Comp2005.models.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Comp2005ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testAppConnection() {
		String url = "http://localhost:" + port;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		// Verify the response status code is OK
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test
	public void testApiConnection() {
		String url = "https://web.socem.plymouth.ac.uk/COMP2005/api/";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		// Verify the response status code is OK
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@MockBean
	private RestTemplate MockRestTemplate;

	@Test
	public void testFetchDataFromExternalApi() {
		MockitoAnnotations.openMocks(this);

		String apiUrl = "https://web.socem.plymouth.ac.uk/COMP2005/api";
		String requestExt = "/Employees";
		String responseData = "Response data from API";
		ResponseEntity<String> responseEntity = new ResponseEntity<>(responseData, HttpStatus.OK);

		// Mock the response entity for the restTemplate.getForEntity call
		when(MockRestTemplate.getForEntity(apiUrl + requestExt, String.class)).thenReturn(responseEntity);

		// Create an instance of MaternityAPIService
		maternityAPIService maternityAPIService = new maternityAPIService(MockRestTemplate, apiUrl);

		// Call the fetchDataFromExternalApi method
		String result = maternityAPIService.fetchDataFromExternalApi(requestExt);

		System.out.println("Fetched data from API: " + result);

		// Verify that the response from the API matches the result from the method
		assertEquals(responseData, result);
	}
}
