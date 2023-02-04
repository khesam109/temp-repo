package com.khesam.trivialspring.service;

import com.khesam.trivialspring.service.domain.Account;

import java.util.UUID;

public interface AccountService {

    Account getAccount(UUID accountId);
    UUID createAccount(UUID customerId, int balance);
    void suspendAccount(UUID accountId);
    void openAccount(UUID accountId);
    void deleteAccount(UUID accountId);
}
