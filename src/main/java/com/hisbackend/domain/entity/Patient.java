package com.hisbackend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Patient.listPatients",
                query = "SELECT * FROM PATIENTS",
                resultClass = Patient.class
        )
})

@Data
@AllArgsConstructor
@Entity
@Table(name="PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String surname;
    private String pesel;

    public Patient(){

    }

    public Patient(String firstname, String surname, String pesel) {
        this.firstname = firstname;
        this.surname = surname;
        this.pesel = pesel;
    }
}