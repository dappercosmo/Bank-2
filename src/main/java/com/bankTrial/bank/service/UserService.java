package com.bankTrial.bank.service;

import com.bankTrial.bank.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> registerUser(User user);
}
