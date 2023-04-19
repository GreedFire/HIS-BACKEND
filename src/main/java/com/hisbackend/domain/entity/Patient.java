package com.hisbackend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

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
    private String sex;
    private String status;
    private LocalDateTime registrationDate;
    private LocalDateTime scheduledDate;

    public Patient(){

    }

    public Patient( String firstname, String surname, String pesel, String sex, String status, LocalDateTime scheduledDate) {
        this.firstname = firstname;
        this.surname = surname;
        this.pesel = pesel;
        this.sex = sex;
        this.status = status;
        this.registrationDate = LocalDateTime.now();
        this.scheduledDate = scheduledDate;
    }


}