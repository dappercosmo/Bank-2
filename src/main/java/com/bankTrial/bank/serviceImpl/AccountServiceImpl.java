package com.bankTrial.bank.serviceImpl;

import com.bankTrial.bank.model.Account;
import com.bankTrial.bank.model.AccountType;
import com.bankTrial.bank.model.User;
import com.bankTrial.bank.repository.AccountRepository;
import com.bankTrial.bank.repository.UserRepository;
import com.bankTrial.bank.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private static final String ACCOUNT_PREFIX="98765";

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Account createAccount(Long userId, String accountType) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("user not found"));
        if(accountRepository.findByUserIdandAccountType(userId, accountType)){
            throw new RuntimeException(accountType+" account already exists for you");
        }
        String accountNumber = generateAccountNumber();
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        account.setAccount_type(AccountType.valueOf(accountType));
        account.setUser(user);
        accountRepository.save(account);
        return account;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        String accountNumber;
        String suffix;
        do{
            suffix = String.format("%05d", random.nextInt(100000));
            accountNumber = ACCOUNT_PREFIX+suffix;
        }while (accountRepository.findByAccountNumber(accountNumber) != null);
        return accountNumber;
    }
}
