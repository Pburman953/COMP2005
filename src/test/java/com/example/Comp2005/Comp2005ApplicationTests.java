package com.example.Comp2005;

import com.example.Comp2005.models.Admission;
import com.example.Comp2005.models.Employee;
import com.example.Comp2005.models.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
	public void testFetchDataFromExternalApi() throws IOException {
		MockitoAnnotations.openMocks(this);

		String apiUrl = "https://web.socem.plymouth.ac.uk/COMP2005/api";
		String requestExt = "/Employees";
		String responseData = "[{\"id\":1,\"surname\":\"Finley\",\"forename\":\"Sarah\"},{\"id\":2,\"surname\":\"Jackson\",\"forename\":\"Robert\"},{\"id\":3,\"surname\":\"Allen\",\"forename\":\"Alice\"},{\"id\":4,\"surname\":\"Jones\",\"forename\":\"Sarah\"},{\"id\":5,\"surname\":\"Wicks\",\"forename\":\"Patrick\"},{\"id\":6,\"surname\":\"Smith\",\"forename\":\"Alice\"}]";
		ResponseEntity<String> responseEntity = new ResponseEntity<>(responseData, HttpStatus.OK);

		// Mock the response entity for the restTemplate.getForEntity call
		//when(MockRestTemplate.getForEntity(apiUrl + requestExt, String.class)).thenReturn(responseEntity);

		ApiController apiController = new ApiController(MockRestTemplate);

		// Call the fetchDataFromExternalApi method
		String result = apiController.fetchDataFromExternalApi(requestExt);

		System.out.println("Fetched data from API: " + result);

		// Verify that the response from the API matches the result from the method
		assertEquals(responseData, result);
	}

	@Test
	public void testF1() throws IOException {
		MockitoAnnotations.openMocks(this);

		ApiController newApiController = new ApiController(MockRestTemplate);

		// Create an instance of the class under test
		maternityAPIService classUnderTest = new maternityAPIService(MockRestTemplate, "https://web.socem.plymouth.ac.uk/COMP2005/api", newApiController);

		// Call the method under test
		List<Admission> result = classUnderTest.F1("Viv", "Robinson");

		// Verify the result
		assertEquals(1, result.size());
		assertEquals(2, result.get(0).getId());
	}

	@Test
	public void testF2() throws IOException {
		MockitoAnnotations.openMocks(this);

		ApiController newApiController = new ApiController(MockRestTemplate);

		// Create an instance of the class under test
		maternityAPIService classUnderTest = new maternityAPIService(MockRestTemplate, "https://web.socem.plymouth.ac.uk/COMP2005/api", newApiController);

		// Call the method under test
		List<Patient> result = classUnderTest.F2();

		// Verify the result
		assertEquals(2, result.size());
	}
	@Test
	public void testF3() throws IOException {
		MockitoAnnotations.openMocks(this);

		ApiController newApiController = new ApiController(MockRestTemplate);

		// Create an instance of the class under test
		maternityAPIService classUnderTest = new maternityAPIService(MockRestTemplate, "https://web.socem.plymouth.ac.uk/COMP2005/api", newApiController);

		// Call the method under test
		Employee result = classUnderTest.F3();

		// Verify the result
		assertEquals(4, result.getId());
	}

	@Test
	public void testF4() throws IOException {
		MockitoAnnotations.openMocks(this);

		ApiController newApiController = new ApiController(MockRestTemplate);

		// Create an instance of the class under test
		maternityAPIService classUnderTest = new maternityAPIService(MockRestTemplate, "https://web.socem.plymouth.ac.uk/COMP2005/api", newApiController);

		// Call the method under test
		List<Employee> result = classUnderTest.F4();

		// Verify the result
		assertEquals(3, result.size());
	}
}
