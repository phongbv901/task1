package com.js.account.controller;

import com.js.account.domain.Account;
import com.js.account.dto.AccountDto;
import com.js.account.dto.Errordto;
import com.js.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @Path("/account/{accountId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountById(@PathParam("accountId") Integer accountId) {
        Account account = accountService.getAccountById(accountId);
        if(account != null){
            return Response.ok().entity(account).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(new Errordto("Account not found!")).build();
        }
    }

    @Path("/account")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAll(){
        return accountService.getAll();
    }


    @Path("/account")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer createAccount(AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @Path("/account/{accountId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccount(@PathParam("accountId") Integer accountId, AccountDto accountDto){
        // In real project, there will be have a return bad request message. I just do happy case in here
        if(accountDto != null){
            accountDto.setId(accountId);
            accountService.updateAccount(accountDto);
        }
        return Response.ok().build();
    }
}
