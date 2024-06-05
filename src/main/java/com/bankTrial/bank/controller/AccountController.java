package com.bankTrial.bank.controller;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create/{id}")
    public Account createAccount(@PathVariable Long id, @RequestParam String accountType){
        return accountService.createAccount(id, accountType);
    }
}
