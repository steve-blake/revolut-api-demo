package com.revolut.api.demo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.revolut.api.demo.api.Account;
import com.revolut.api.demo.core.AccountDAO;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/account")
public class AccountResource {

    private static final String MESSAGE = "Account API";

    @GET
    @Produces(APPLICATION_JSON)
    public String setup() {
        return new String(MESSAGE);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") int id) {
        return AccountDAO.getById(id);
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts() {
        return AccountDAO.getAll();
    }

    @GET
    @Path("/transfer/{fromId}/{toId}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public double transferBetweenAccounts(@PathParam("fromId") int fromId, @PathParam("toId") int toId, @PathParam("amount") double amount) {
        double balance = AccountDAO.transferBetweenAccounts(fromId, toId, amount);
        return (double) Math.round(balance * 100) / 100;
    }

    @GET
    @Path("/withdraw/{id}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public double withdrawFromAccount(@PathParam("id") int id, @PathParam("amount") double amount) {
        double balance = AccountDAO.withdrawFromAccount(id, amount);
        return (double) Math.round(balance * 100) / 100;
    }

    @GET
    @Path("/deposit/{id}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public double depositIntoAccount(@PathParam("id") int id, @PathParam("amount") double amount) {
        double balance = AccountDAO.depositIntoAccount(id, amount);
        return (double) Math.round(balance * 100) / 100;
    }

    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String updateAccount(Account account) {
        return AccountDAO.updateAccount(account);
    }
}

