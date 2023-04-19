package com.hisbackend.mapper;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToEntity(UserDto userDto) {
        return new User(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurname()
        );
    }

    public UserDto mapToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.isSignedIn());
}
}