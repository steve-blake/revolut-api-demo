package com.revolut.api.demo.model;

/**
 * Created by steve_blake on 21/07/2017.
 */
public class User {

    private String firstName;
    private String lastName;
    private double userId;

    private Account account = new Account();

    /**
     * User model for money transfers between internal users/accounts.
     *
     * @param firstName
     * @param lastName
     * @param userId
     * @param account
     */
    public User(String firstName, String lastName, double userId, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
