package com.hisbackend;

import com.hisbackend.domain.entity.Patient;
import com.hisbackend.domain.entity.User;
import com.hisbackend.repository.PatientRepository;
import com.hisbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(String...args) throws Exception {
        User user = new User("ADMIN","ADMIN","ADMIN","ADMIN");
        userRepository.save(user);

        Patient patient = new Patient("Dawid", "Majchrzak", "00000000000");
        Patient patient2 = new Patient("Anna", "Nowacka", "11111111111");
        Patient patient3 = new Patient("Paweł", "Kowalski", "22222222222");
        patientRepository.save(patient);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

    }
}
