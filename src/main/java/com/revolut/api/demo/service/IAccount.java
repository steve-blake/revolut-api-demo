package com.revolut.api.demo.service;

import com.revolut.api.demo.model.Account;
import com.revolut.api.demo.utils.AccountAccessException;

import java.util.List;

/**
 * Created by steve_blake on 21/07/2017.
 */
public interface IAccount {

    Account insert(Account account) throws AccountAccessException;

    Account getById(long accountId) throws AccountAccessException;

    Account update(Account account) throws AccountAccessException;

    void lockById(long accountId) throws AccountAccessException;

    void unlockById(long accountId) throws AccountAccessException;

    List<Account> getAll() throws AccountAccessException;

    void deleteAll() throws AccountAccessException;
}
