package com.example.Comp2005;

import com.example.Comp2005.models.Admission;
import com.example.Comp2005.models.Allocation;
import com.example.Comp2005.models.Employee;
import com.example.Comp2005.models.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonProcessor {

    public List<Admission> admissionList = new ArrayList<>();
    public List<Allocation> allocationList = new ArrayList<>();
    public List<Employee> employeeList = new ArrayList<>();
    public List<Patient> patientList = new ArrayList<>();





    public void JsonToModelConverter(String ModelName, String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json);

        switch(ModelName){
            case "Admission":
                for (JsonNode node : jsonNode){
                    Admission newAdmission = objectMapper.treeToValue(node, Admission.class);
                    admissionList.add(newAdmission);
                }
                break;
            case "Allocation":
                for(JsonNode node : jsonNode){
                    Allocation newAllocation = objectMapper.treeToValue(node, Allocation.class);
                    allocationList.add(newAllocation);
                }
                break;
            case "Employee":
                for(JsonNode node : jsonNode){
                    Employee newEmployee = objectMapper.treeToValue(node, Employee.class);
                    employeeList.add(newEmployee);
                }
                break;
            case "Patient":
                for(JsonNode node : jsonNode){
                    Patient newPatient = objectMapper.treeToValue(node, Patient.class);
                    patientList.add(newPatient);
                }
                break;
        }

    }

}
