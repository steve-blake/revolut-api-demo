package com.revolut.api.demo.core;

import com.revolut.api.demo.api.Account;
import com.revolut.api.demo.api.User;

import java.util.*;

public class UserDAO {

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    // Setup accounts with dummy data
    static {
        AccountDAO account = new AccountDAO();
        users.put(1, new User("Name A", "Last A", 1, account.getById(1)));
        users.put(2, new User("Name B", "Last B", 2, account.getById(2)));
        users.put(3, new User("Name C", "Last C", 3, account.getById(3)));
    }

    /**
     *
     * @param id
     * @return
     */
    public static User getById(int id) {
        return users.get(id);
    }

    /**
     *
     * @return
     */
    public static List<User> getAll() {
        List<User> result = new ArrayList<>();
        for (Integer key : users.keySet()) {
            result.add(users.get(key));
        }
        return result;
    }

    public static String updateUser(User user) {
        String result = "";
        if (users.get(user.getUserId()) != null) {
            result = "Updated User with id=" + user.getUserId();
        } else {
            result = "Added User with id=" + user.getUserId();
        }
        users.put(user.getUserId(), user);
        return result;
    }
}
