package com.khesam.trivialspring.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts", schema = "account")
public class AccountsEntity {

    @Id
    private String id;
    private String customerId;
    private int balance;
    private String accountStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
