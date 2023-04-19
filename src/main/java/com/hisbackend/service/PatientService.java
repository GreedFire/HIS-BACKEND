package com.hisbackend.service;

import com.hisbackend.domain.dto.PatientDto;
import com.hisbackend.domain.entity.Patient;
import com.hisbackend.mapper.PatientMapper;
import com.hisbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public boolean registerPatient(PatientDto patientDto){
        Patient patient = patientMapper.mapToEntity(patientDto);

        if(patient != null) {
            patientRepository.save(patient);
            return true;
        }
        else return false;
    }
    public List<PatientDto> getPatients() {
        return patientMapper.mapToDtoList(patientRepository.findAll());
    }
}
