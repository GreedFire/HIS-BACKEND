package com.hisbackend.repository;

import com.hisbackend.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoTestSuite {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testUserDao(){
        //Given
        User user = new User("GreedFire", "1234", "Dawid", "Majchrzak");
        //When
        userRepository.save(user);
        String name = user.getName();
        //Then
        Assertions.assertEquals("Dawid", name );

    }
}
