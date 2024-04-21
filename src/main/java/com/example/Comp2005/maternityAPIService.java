package com.example.Comp2005;
import com.example.Comp2005.models.Admission;
import com.example.Comp2005.models.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.example.Comp2005.JsonProcessor;
import java.util.ArrayList;
import java.util.List;


@Service
public class maternityAPIService {

    private final RestTemplate restTemplate;
    private final String apiUrl; // Base URL of the external API

    public maternityAPIService(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }


    public String fetchDataFromExternalApi(String requestExt) {
        ApiController apiController = new ApiController(restTemplate);
        return apiController.fetchDataFromApi(apiUrl + requestExt);
    }


    public List<Admission> F1(String forename, String surname) throws JsonProcessingException {
        JsonProcessor newJsonProcessor = new JsonProcessor();

        List<Admission> patientsAdmissions = new ArrayList<>();

        newJsonProcessor.JsonToModelConverter( "Patient", fetchDataFromExternalApi("/patients"));
        newJsonProcessor.JsonToModelConverter( "Admission", fetchDataFromExternalApi("/admissions"));

        Patient foundPatient = null;

        int foundPatientId = -1;

        for (Patient patient : newJsonProcessor.patientList) {
            if (patient.getForename().equals(forename) && patient.getSurname().equals(surname)) {
                foundPatient = patient;
                break;
            }
        }

        if (foundPatient != null) {
            foundPatientId = foundPatient.getId();
            System.out.println("Patient found with ID: " + foundPatientId);
        } else {
            System.out.println("Patient with name '" + forename + "' not found.");
        }

        if(foundPatientId != -1) {
            for (Admission admission : newJsonProcessor.admissionList) {
                if (admission.getPatientID() == (foundPatientId)) {
                    patientsAdmissions.add(admission);
                    break;
                }
            }
        }
        return patientsAdmissions;
    }


}

