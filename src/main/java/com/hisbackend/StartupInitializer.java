package com.hisbackend;

import com.hisbackend.domain.entity.User;
import com.hisbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        User user = new User("ADMIN","ADMIN","ADMIN","ADMIN");
        userRepository.save(user);
    }
}
