package com.revolut.api.demo.utils;

/**
 * Created by steve_blake on 20/07/2017.
 */
public class Validation {
    public static void checkNotNull(Object o, String msg) {
        if (o == null) {
            error(msg);
        }
    }

    private static void error(String msg) {
        throw new IllegalArgumentException(msg);
    }
}
