package com.revolut.api.demo.service;


import com.revolut.api.demo.model.Account;
import com.revolut.api.demo.model.AccountDAO;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountService {

    // URI:
    // /contextPath/servletPath/accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts_JSON() {
        List<Account> listOfAccounts = AccountDAO.getAllAccounts();
        return listOfAccounts;
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("accountId") long accountId) {
        return AccountDAO.getAccount(accountId);
    }

    @Path("/transfer/{accountIdFrom}/{amountFrom}/{accountIdTo}/{amountTo}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean transferBetweenAccounts(@PathParam("accountIdFrom") long accountIdFrom,
                                           @PathParam("amountFrom") double amountFrom,
                                           @PathParam("accountIdTo") long accountIdTo,
                                           @PathParam("amountTo") double amountTo)
    {
        return AccountDAO.transferBetweenAccounts(accountIdFrom, amountFrom, accountIdTo, amountTo);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Account updateAccount(Account account) {
        return AccountDAO.updateAccount(account);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Account addAccount(Account account) {
        return AccountDAO.addAccount(account);
    }

    @DELETE
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAccount(@PathParam("accountId") long accountId) {
        AccountDAO.deleteAccount(accountId);
    }

}
