package com.khesam.trivialspring.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CreateAccountCommand {

    @JsonProperty("customerId")
    private UUID customerId;
    @JsonProperty("balance")
    private int balance;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
