package com.hisbackend.mapper;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToEntity(UserDto userDto) {
        final User user = new User(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurname()
        );
        return user;
    }
}
