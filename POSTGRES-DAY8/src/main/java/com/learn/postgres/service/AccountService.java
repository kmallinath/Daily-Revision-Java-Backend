package com.learn.postgres.service;

import com.learn.postgres.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BigDecimal getBalance(Long accountId) {
        return accountRepository.getAccountBalance(accountId);
    }
}
