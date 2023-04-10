package com.hisbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private long id;
    private String firstname;
    private String surname;
    private String pesel;

}
