package com.revolut.api.demo.model;

import java.util.*;

/**
 * Created by steve_blake on 21/07/2017.
 */
public class AccountDAO {

    private static final Map<Long, Account> dummyAccounts = new HashMap<Long, Account>();

    static {
        initAccounts();
    }

    private static void initAccounts() {

        Account acc1 = new Account(01, Account.AccountType.CURRENT, "Account 1", Currency.getInstance("GBP"), 100.00);
        Account acc2 = new Account(02, Account.AccountType.CHEQUE, "Account 2", Currency.getInstance("GBP"), 200.00);
        Account acc3 = new Account(03, Account.AccountType.SAVINGS, "Account 3", Currency.getInstance("GBP"),300.00);

        dummyAccounts.put(acc1.getAccountId(), acc1);
        dummyAccounts.put(acc2.getAccountId(), acc2);
        dummyAccounts.put(acc3.getAccountId(), acc3);
    }

    public static Account getAccount(double accountId) {
        return dummyAccounts.get(accountId);
    }

    public static List<Account> getAllAccounts() {
        Collection<Account> collection = dummyAccounts.values();
        List<Account> list = new ArrayList<Account>();
        list.addAll(collection);
        return list;
    }

    public static boolean transferBetweenAccounts(long accountIdFrom, double amountFrom, long accountIdTo, double amountTo)
    {
        try {

            Account

        } catch (Exception ex){

        }


        return true;

    }

    public static Account addAccount(Account account) {
        dummyAccounts.put(account.getAccountId(), account);
        return account;
    }

    public static Account updateAccount(Account account) {
        dummyAccounts.put(account.getAccountId(), account);
        return account;
    }

    public static void deleteAccount(long accountId) {
        dummyAccounts.remove(accountId);
    }

    public double deposit(long accountId, double balance, double amount) {
        return balance += amount;
    }

    public double withdraw(long accountId, double balance, double amount) {
        return balance -= amount;
    }
}
