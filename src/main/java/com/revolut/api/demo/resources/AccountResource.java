package com.revolut.api.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.revolut.api.demo.api.IAccount;
import com.revolut.api.demo.model.Account;
import com.revolut.api.demo.utils.AccountAccessException;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    //private final IAccount accountInterface;
    private final String defaultName;

    public AccountResource(String defaultName) {
        this.defaultName = defaultName;
        //this.accountInterface = accountInterface;
    }

    /*@GET
    public List<Account> getAllAccounts() throws AccountAccessException {

        //return accountInterface.getAllAccounts();
    }*/

    @GET
    public Account getAccount(@QueryParam("id") long accountId) throws AccountAccessException {
        try {
          //  Account account = accountInterface.getAccountById(accountId);
            return new Account();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new Account();
    }
}

