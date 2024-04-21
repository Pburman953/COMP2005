package com.example.Comp2005;

import com.example.Comp2005.models.Admission;
import com.example.Comp2005.models.Allocation;
import com.example.Comp2005.models.Employee;
import com.example.Comp2005.models.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonProcessor {

    List<Admission> admissionList = new ArrayList<>();
    List<Allocation> allocationList = new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    List<Patient> patientList = new ArrayList<>();





    public void JsonToModelConverter(String ModelName, String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        switch(ModelName){
            case "Admission":
                Admission Admission = objectMapper.readValue(json, Admission.class);
                break;
            case "Allocation":
                Allocation Allocation = objectMapper.readValue(json, Allocation.class);
                break;
            case "Employee":
                Employee Employee = objectMapper.readValue(json, Employee.class);
                break;
            case "Patient":
                Patient Patient = objectMapper.readValue(json, Patient.class);
                break;
        }

    }

}
