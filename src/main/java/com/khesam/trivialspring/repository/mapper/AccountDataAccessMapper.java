package com.khesam.trivialspring.repository.mapper;

import com.khesam.trivialspring.repository.entity.AccountsEntity;
import com.khesam.trivialspring.service.domain.Account;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountDataAccessMapper {

    public Account toAccount(AccountsEntity entity) {
        return Account.Builder.builder()
                .id(UUID.fromString(entity.getId()))
                .customerId(UUID.fromString(entity.getCustomerId()))
                .balance(entity.getBalance())
                .status(entity.getAccountStatus())
                .build();
    }
}
