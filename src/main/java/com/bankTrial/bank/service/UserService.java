package com.bankTrial.bank.service;

import com.bankTrial.bank.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User registerUser(String firstName, String lastName, String email, String password);
}
