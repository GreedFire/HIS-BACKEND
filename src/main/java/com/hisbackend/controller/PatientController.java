package com.hisbackend.controller;

import com.hisbackend.domain.dto.PatientDto;
import com.hisbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("his/patients")
public class PatientController {
    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean registerPatient(@RequestBody PatientDto patientDto){
        return patientService.registerPatient(patientDto);
    }

    @GetMapping("/getPatients")
    public List<PatientDto> getPatients() {
         return patientService.getPatients();
    }

    @DeleteMapping("/deletePatient")
    public void deletePatient(@RequestParam long patientId){
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "/updatePatient", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void updatePatient(@RequestBody PatientDto patientDto){
        patientService.updatePatient(patientDto);
    }
}
