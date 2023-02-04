package com.khesam.trivialspring.service.domain;

import java.util.UUID;

public class Account {

    private final UUID id;
    private final UUID customerId;
    private final int balance;
    private final String status;

    private Account(Builder builder) {
        id = builder.id;
        customerId = builder.customerId;
        balance = builder.balance;
        status = builder.status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public int getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public static final class Builder {
        private UUID id;
        private UUID customerId;
        private int balance;
        private String status;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder customerId(UUID val) {
            customerId = val;
            return this;
        }

        public Builder balance(int val) {
            balance = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
