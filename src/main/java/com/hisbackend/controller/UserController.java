package com.hisbackend.controller;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("his/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getId")
    public Long getId(@RequestParam String username, @RequestParam String password) {
        return userService.getId(username, password);
    }

    @PutMapping("/signIn")
    public void signIn(@RequestParam long userId) {
        userService.signIn(userId);
    }

    @GetMapping("/getUser")
    public UserDto getUser(@RequestParam long id) {
        return userService.getUser(id);
    }
}
