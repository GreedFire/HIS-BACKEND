package com.hisbackend.repository;

import com.hisbackend.domain.entity.Patient;
import com.hisbackend.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient save(Patient patient);

    @Override
    List<Patient> findAll();

    @Modifying
    @Query("update Patient e set e.firstname = ?1, e.surname = ?2, e.pesel = ?3, e.sex = ?4," +
            " e.scheduledDate = ?5 where e.id = ?6")
    void updateById(String firstname, String surname, String pesel, String sex, LocalDateTime scheduleDate, long id);

}
