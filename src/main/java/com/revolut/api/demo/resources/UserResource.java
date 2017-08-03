package com.revolut.api.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.revolut.api.demo.api.IUser;
import com.revolut.api.demo.model.User;
import com.revolut.api.demo.utils.AccountAccessException;

import java.util.List;

@Path("/user")
public class UserResource {

    private final String defaultName;

    public UserResource(String defaultName) {
        this.defaultName = defaultName;
    }

    /*@GET
    @Produces(APPLICATION_JSON)
    public List<User> getAllUsers() throws AccountAccessException {

        return List();
    }*/

}

