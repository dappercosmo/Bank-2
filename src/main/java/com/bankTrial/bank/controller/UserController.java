package com.bankTrial.bank.controller;

import com.bankTrial.bank.model.User;
import com.bankTrial.bank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/register")
    ResponseEntity<User> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
