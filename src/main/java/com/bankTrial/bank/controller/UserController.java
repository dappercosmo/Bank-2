package com.bankTrial.bank.controller;

import com.bankTrial.bank.model.User;
import com.bankTrial.bank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/register")
    public User registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password){
        return userService.registerUser(firstName, lastName, email, password);
//        return userService.registerUser();
    }
}
