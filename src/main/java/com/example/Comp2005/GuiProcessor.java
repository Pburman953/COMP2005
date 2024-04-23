package com.example.Comp2005;

import com.example.Comp2005.models.Admission;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiProcessor {

    private final RestTemplate restTemplate;

    public String searchBarInput;

    public List<Admission> patientAdmissions = new ArrayList<>();

    public GuiProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void processInput(String input) throws IOException {
        if(searchBarInput != null){
            input = input.trim();
            String[] splitInput = input.split("\\s+");
            if(splitInput.length == 2){
                maternityAPIService newMAS = new maternityAPIService(restTemplate, AppConfig.apiURL);
                patientAdmissions = newMAS.F1(splitInput[0], splitInput[1]);
                for(Admission admission : patientAdmissions){
                    System.out.print(admission.getId());
                }
            }
        }
    }


}
