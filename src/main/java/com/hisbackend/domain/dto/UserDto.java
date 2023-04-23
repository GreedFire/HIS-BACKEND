package com.hisbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private boolean signedIn;

    public UserDto(long id, String username, String name, String surname, boolean signedIn) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.signedIn = signedIn;
    }
}
