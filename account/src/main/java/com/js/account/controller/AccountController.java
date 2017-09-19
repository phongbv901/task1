package com.js.account.controller;

import com.js.account.domain.Account;
import com.js.account.domain.AccountBuilder;
import com.js.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @Path("/account/{accountId}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountById(@PathParam("accountId") Integer accountId){
        AccountBuilder builder = new AccountBuilder(1,"","us");
        builder.withAmount(10.5);
        return builder.build();
    }
}
