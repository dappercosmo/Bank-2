package com.bankTrial.bank.serviceImpl;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.model.User;
import com.bankTrial.bank.repository.UserRepository;
import com.bankTrial.bank.service.AccountService;
import com.bankTrial.bank.service.UserService;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) {
        User savedUser = new User();
        savedUser.setFirstName(firstName);
        savedUser.setLastName(lastName);
        savedUser.setEmail(email);
        savedUser.setPassword(password);
        return userRepository.save(savedUser);

    }


}
