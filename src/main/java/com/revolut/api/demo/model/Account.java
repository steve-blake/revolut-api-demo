package com.revolut.api.demo.model;

import com.revolut.api.demo.utils.Validation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Currency;

/**
 * Account model for money transfers between internal users/accounts.
 *
 * Created by steve_blake on 20/07/2017.
 *
 *
 *
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 *
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
    public Account(long accountId, AccountType accountType, String accountName, Currency currency, double balance) {
        Validation.checkNotNull(accountId, "account id is required");
        Validation.checkNotNull(accountName, "account name is required");
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance(long accountId) {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
