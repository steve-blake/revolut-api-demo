package com.revolut.api.demo.api;

import com.revolut.api.demo.model.Account;
import com.revolut.api.demo.utils.AccountAccessException;

import java.util.List;

public interface IAccount {

    Account addAccount(Account account) throws AccountAccessException;

    Account getAccountById(long accountId) throws AccountAccessException;

    Account updateAccount(Account account) throws AccountAccessException;

    List<Account> getAllAccounts() throws AccountAccessException;
}

