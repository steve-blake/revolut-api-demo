package com.revolut.api.demo.resources;

import com.codahale.metrics.annotation.Timed;
import com.revolut.api.demo.api.Account;
import com.revolut.api.demo.api.User;
import com.revolut.api.demo.core.AccountDAO;
import com.revolut.api.demo.core.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/user")
public class UserResource {

    private static final String MESSAGE = "Account API";

    @GET
    @Produces(APPLICATION_JSON)
    public String setup() {
        return new String(MESSAGE);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) {
        return UserDAO.getById(id);
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return UserDAO.getAll();
    }

    @POST
    @Timed
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String updateUser(User user) {
        return UserDAO.updateUser(user);
    }

}

