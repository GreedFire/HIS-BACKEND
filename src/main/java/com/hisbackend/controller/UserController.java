package com.hisbackend.controller;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.domain.entity.User;
import com.hisbackend.mapper.UserMapper;
import com.hisbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("his/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/getId")
    public Long getId(@RequestParam String username, @RequestParam String password) {
        Long id = null;
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            id = user.get().getId();
        }

        return id;
    }

    @PutMapping("/signIn")
    public void signIn(@RequestParam long userId) {
        userRepository.signIn(userId);
    }

    @GetMapping("/getUser")
    public UserDto getUser(@RequestParam long id) {
        UserDto userDto = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            userDto = userMapper.mapToDto(user.get());

        return userDto;
    }


}
