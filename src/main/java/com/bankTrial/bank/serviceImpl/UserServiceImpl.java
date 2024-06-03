package com.bankTrial.bank.serviceImpl;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.model.User;
import com.bankTrial.bank.repository.UserRepository;
import com.bankTrial.bank.service.AccountService;
import com.bankTrial.bank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<User> registerUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User savedUser = userRepository.save(user);

        Account account = accountService.createAccount(savedUser);
        savedUser.setAccount(account);
        userRepository.save(savedUser);
        return ResponseEntity.ok(savedUser);
    }
}
