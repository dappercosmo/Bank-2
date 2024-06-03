package com.bankTrial.bank.service;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.model.User;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    Account createAccount(User user);
}
