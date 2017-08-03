package com.revolut.api.demo.api;

import com.revolut.api.demo.model.User;
import com.revolut.api.demo.utils.AccountAccessException;

import java.util.List;

public interface IUser {

    User addUser(User user) throws AccountAccessException;

    User getUserById(long userId) throws AccountAccessException;

    User updateUser(User user) throws AccountAccessException;

    List<User> getAllUsers() throws AccountAccessException;
}

