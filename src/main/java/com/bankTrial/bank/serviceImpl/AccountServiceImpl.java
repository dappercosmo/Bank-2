package com.bankTrial.bank.serviceImpl;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.model.User;
import com.bankTrial.bank.repository.AccountRepository;
import com.bankTrial.bank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(User user) {
        String accountNumber = generateAccountNumber();
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        accountRepository.save(account);
        return account;
    }

    private String generateAccountNumber() {
        String accountNumber;
        do{
            accountNumber = UUID.randomUUID().toString().substring(0,6);
        }while (accountRepository.findByAccountNumber(accountNumber) != null);
        return accountNumber;
    }
}
