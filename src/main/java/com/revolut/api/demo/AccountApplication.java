package com.revolut.api.demo;

import com.revolut.api.demo.resources.AccountResource;
import com.revolut.api.demo.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;

public class AccountApplication extends Application<AccountConfig> {
    public static void main(String[] args) throws Exception {
        new AccountApplication().run(args);
    }

    public void run(AccountConfig config, Environment environment) throws Exception {
        environment.getObjectMapper().setPropertyNamingStrategy(SNAKE_CASE);

        // Register resources for API
        environment.jersey().register(new AccountResource());
        environment.jersey().register(new UserResource());
    }
}
