package com.hisbackend.service;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.domain.entity.User;
import com.hisbackend.mapper.UserMapper;
import com.hisbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public Long getId(String username, String password) {
        Long id = null;
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            id = user.get().getId();
        }

        return id;
    }

    public void signIn(long userId) {
        userRepository.signIn(userId);
    }

    public UserDto getUser(long id) {
        UserDto userDto = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            userDto = userMapper.mapToDto(user.get());

        return userDto;
    }
}
