package com.khesam.trivialspring.service.impl;

import com.khesam.trivialspring.service.AccountService;
import com.khesam.trivialspring.service.domain.Account;
import com.khesam.trivialspring.service.port.output.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(UUID accountId) {
        return accountRepository.getAccount(
                accountId.toString()
        );
    }

    @Override
    public UUID createAccount(UUID customerId, int balance) {
        return accountRepository.createAccount(
                customerId.toString(), balance
        );
    }

    @Override
    public void suspendAccount(UUID accountId) {
        accountRepository.updateAccountStatus(
                accountId.toString(), "suspend"
        );
    }

    @Override
    public void openAccount(UUID accountId) {
        accountRepository.updateAccountStatus(
                accountId.toString(), "open"
        );
    }

    @Override
    public void deleteAccount(UUID accountId) {
        accountRepository.deleteAccount(
                accountId.toString()
        );
    }
}
