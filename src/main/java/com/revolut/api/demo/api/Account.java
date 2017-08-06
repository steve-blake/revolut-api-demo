package com.revolut.api.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Currency;

/**
 * Account model for money transfers between internal users/accounts.
 *
 * Created by steve_blake on 20/07/2017.
 */
 public class Account {

    public int accountId;
    public AccountType accountType;
    public String accountName;
    public Currency currency;
    public double balance;

    public enum AccountType {
        SAVINGS,
        CHEQUE,
        CURRENT
    }

    public Account() {
        // empty constructor
    }

    /**
     *
     * @param accountId
     * @param accountType
     * @param accountName
     * @param currency
     * @param balance
     */
    public Account(int accountId, AccountType accountType, String accountName, Currency currency, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.currency = currency;
        this.balance = balance;
    }

    @JsonProperty
    public int getAccountId() {
        return accountId;
    }

    @JsonProperty
    public AccountType getAccountType() {
        return accountType;
    }

    @JsonProperty
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty
    public double getBalance() {
        return balance;
    }

    @JsonProperty
    public Currency getCurrency() {
        return currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return (accountId == account.accountId);
    }

    public String toString() {
        return "Account Type: " + this.accountType + " | Account name: " + this.accountName + " | Account balance: " + this.currency + this.balance;
    }
}
