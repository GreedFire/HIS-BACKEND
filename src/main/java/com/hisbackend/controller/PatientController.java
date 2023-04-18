package com.hisbackend.controller;

import com.hisbackend.domain.dto.PatientDto;
import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.domain.entity.Patient;
import com.hisbackend.domain.entity.User;
import com.hisbackend.mapper.PatientMapper;
import com.hisbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("his/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @PostMapping(path = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean registerPatient(@RequestBody PatientDto patientDto){
        Patient patient = patientMapper.mapToEntity(patientDto);

        if(patient != null) {
            patientRepository.save(patient);
            return true;
        }
        else return false;
    }

    @GetMapping("/getPatients")
    public List<PatientDto> getPatients() {
         return patientMapper.mapToDtoList(patientRepository.findAll());
    }
}
