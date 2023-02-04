package com.khesam.trivialspring.controller;


import com.khesam.trivialspring.service.AccountService;
import com.khesam.trivialspring.service.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable UUID accountId) {
        return ResponseEntity.ok(
                accountService.getAccount(accountId)
        );
    }

    @PostMapping
    public UUID createAccount(@RequestBody CreateAccountCommand createAccountCommand) {
        return accountService.createAccount(
                createAccountCommand.getCustomerId(), createAccountCommand.getBalance()
        );
    }

    @PutMapping("/{accountId}/suspend")
    public ResponseEntity<Void> suspendAccount(@PathVariable UUID accountId) {
        accountService.suspendAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{accountId}/open")
    public ResponseEntity<Void> openAccount(@PathVariable UUID accountId) {
        accountService.openAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();    }
}
