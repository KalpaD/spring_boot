package com.kalpads.services.controller;

import com.kalpads.services.accounts.Account;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * A RESTFul controller for accessing information.
 * 
 * Created by Kalpa on 2/10/16.
 */

@RestController
public class AccountsController {

    protected Logger logger = Logger.getLogger(AccountsController.class.getName());

    @RequestMapping("accounts/{accountNumber}")
    public Account getAccountByNumber(@PathVariable("accountNumber") String accountNumber) {

        logger.info("accounts-service byNumber() invoked: " + accountNumber);
        Account account = new Account();
        account.setAccountName("Kalpa");
        account.setAccountNumber(accountNumber);
        account.setBalance(new BigDecimal("77777"));
        return account;
    }
}
