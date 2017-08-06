package com.revolut.api.demo.api;

/**
 * Created by steve_blake on 21/07/2017.
 */
public class User {

    private String firstName;
    private String lastName;
    private int userId;

    private Account account = new Account();

    /**
     * User model for money transfers between internal users/accounts.
     *
     * @param firstName
     * @param lastName
     * @param userId
     * @param account
     */
    public User(String firstName, String lastName, int userId, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return (userId == user.userId);
    }
}
