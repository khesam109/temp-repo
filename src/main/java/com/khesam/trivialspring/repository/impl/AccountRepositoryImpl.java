package com.khesam.trivialspring.repository.impl;

import com.khesam.trivialspring.common.AccountNotFoundException;
import com.khesam.trivialspring.common.Config;
import com.khesam.trivialspring.repository.AccountJpaRepository;
import com.khesam.trivialspring.repository.entity.AccountsEntity;
import com.khesam.trivialspring.repository.mapper.AccountDataAccessMapper;
import com.khesam.trivialspring.service.domain.Account;
import com.khesam.trivialspring.service.port.output.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;
    private final AccountDataAccessMapper accountDataAccessMapper;
    private final Config config;

    @Autowired
    public AccountRepositoryImpl(
            AccountJpaRepository accountJpaRepository,
            AccountDataAccessMapper accountDataAccessMapper,
            Config config
    ) {
        this.accountJpaRepository = accountJpaRepository;
        this.accountDataAccessMapper = accountDataAccessMapper;
        this.config = config;
    }

    public Account getAccount(String accountId) {
        return accountDataAccessMapper.toAccount(
                accountJpaRepository.findById(accountId)
                        .orElseThrow(AccountNotFoundException::new)
        );
    }

    @Transactional
    @Override
    public UUID createAccount(String customerId, int balance) {
        AccountsEntity entity = new AccountsEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setCustomerId(customerId);
        entity.setBalance(balance);
        entity.setAccountStatus(config.getBaseStatus());

        accountJpaRepository.save(entity);
        return UUID.fromString(entity.getId());
    }

    @Override
    public void updateAccountStatus(String accountId, String accountStatus) {
        AccountsEntity entity = accountJpaRepository.findById(accountId)
                .orElseThrow(AccountNotFoundException::new);
        entity.setAccountStatus(accountStatus);

        accountJpaRepository.save(entity);
    }

    @Override
    public void deleteAccount(String accountId) {
        AccountsEntity entity = accountJpaRepository.findById(accountId)
                .orElseThrow(AccountNotFoundException::new);

        accountJpaRepository.delete(entity);
    }
}
