package com.revolut.api.demo.core;

import com.revolut.api.demo.api.Account;

import java.util.*;

public class AccountDAO {

    private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();

    // Setup accounts with dummy data
    static {
        accounts.put(1, new Account(1, Account.AccountType.CURRENT, "Account 1", Currency.getInstance("GBP"), 99.99));
        accounts.put(2, new Account(2, Account.AccountType.SAVINGS, "Account 2", Currency.getInstance("GBP"), 199.99));
        accounts.put(3, new Account(3, Account.AccountType.CHEQUE, "Account 3", Currency.getInstance("GBP"), 59.99));
    }

    /**
     *
     * @param id
     * @return
     */
    public static Account getById(int id) {
        return accounts.get(id);
    }

    /**
     *
     * @return
     */
    public static List<Account> getAll() {
        List<Account> result = new ArrayList<>();
        for (Integer key : accounts.keySet()) {
            result.add(accounts.get(key));
        }
        return result;
    }

    /**
     *
     * @param fromAccountId
     * @param toAccountId
     * @param amount
     * @return
     */
    public static double transferBetweenAccounts(int fromAccountId, int toAccountId, double amount) {
        // Load account to transfer from
        AccountDAO accountFrom = new AccountDAO();
        accountFrom.withdrawFromAccount(fromAccountId, amount);

        // Load account to transfer to
        AccountDAO accountTo = new AccountDAO();
        accountTo.depositIntoAccount(toAccountId, amount);

        Account account = accounts.get(toAccountId);
        return account.getBalance();
    }

    /**
     *
     * @param id
     * @param amount
     * @return
     */
    public static double withdrawFromAccount(int id, double amount) {
        Account account = accounts.get(id);
        return account.balance = account.getBalance() - amount;
    }

    /**
     *
     * @param id
     * @param amount
     * @return
     */
    public static double depositIntoAccount(int id, double amount) {
        Account account = accounts.get(id);
        return account.balance = account.getBalance() + amount;
    }

    /**
     *
     * @param account
     * @return
     */
    public static String updateAccount(Account account) {
        String result = "";
        if (accounts.get(account.getAccountId()) != null) {
            result = "Updated Account with id=" + account.getAccountId();
        } else {
            result = "Added Account with id=" + account.getAccountId();
        }
        accounts.put(account.getAccountId(), account);
        return result;
    }

    public static int getCount() {
        return accounts.size();
    }
}
