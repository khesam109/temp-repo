package com.khesam.trivialspring.service.port.output;

import com.khesam.trivialspring.service.domain.Account;

import java.util.UUID;

public interface AccountRepository {

    Account getAccount(String accountId);
    UUID createAccount(String customerId, int balance);
    void updateAccountStatus(String accountId, String accountStatus);
    void deleteAccount(String accountId);
}
