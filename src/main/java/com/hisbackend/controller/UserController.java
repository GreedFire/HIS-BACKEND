package com.hisbackend.controller;

import com.hisbackend.domain.dto.UserDto;
import com.hisbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping("/getUsers")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/updateUser", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
    }

    @PutMapping(path = "/updateUserPassword", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void updateUserPassword(@RequestBody UserDto userDto){
        userService.updateUserPassword(userDto);
    }
}
