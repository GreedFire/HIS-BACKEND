package com.hisbackend.mapper;

import com.hisbackend.domain.dto.PatientDto;
import com.hisbackend.domain.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public Patient mapToEntity(PatientDto patientDto) {
        final Patient patient = new Patient(
                patientDto.getFirstname(),
                patientDto.getSurname(),
                patientDto.getPesel(),
                patientDto.getSex(),
                patientDto.getStatus(),
                patientDto.getScheduledDate()
                );
        return patient;
    }

    public PatientDto mapToDto(Patient patient) {
        final PatientDto patientDto = new PatientDto(
                patient.getId(),
                patient.getFirstname(),
                patient.getSurname(),
                patient.getPesel(),
                patient.getSex(),
                patient.getStatus(),
                patient.getRegistrationDate(),
                patient.getScheduledDate()
        );
        return patientDto;
    }

    public List<PatientDto> mapToDtoList(List<Patient> patients) {
        return patients.stream()
                .map(patient -> new PatientDto(
                        patient.getId(),
                        patient.getFirstname(),
                        patient.getSurname(),
                        patient.getPesel(),
                        patient.getSex(),
                        patient.getStatus(),
                        patient.getRegistrationDate(),
                        patient.getScheduledDate()
                ))
                .collect(Collectors.toList());
    }

}