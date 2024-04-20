package com.example.Comp2005;

import com.example.Comp2005.models.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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


}
