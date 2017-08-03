package com.revolut.api.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revolut.api.demo.utils.Validation;
import java.util.Currency;

/**
 * Account model for money transfers between internal users/accounts.
 *
 * Created by steve_blake on 20/07/2017.
 */
 public class Account {

    public long accountId;
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

    @JsonCreator
    public Account(@JsonProperty("account") long accountId, AccountType accountType, String accountName, Currency currency, double balance) {
        Validation.checkNotNull(accountId, "account id is required");
        Validation.checkNotNull(accountName, "account name is required");
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
    }

    @JsonProperty
    public long getAccountId() {
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
    public double getBalance(long accountId) {
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
