package com.kalpads.microservices.client;

import com.kalpads.microservices.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kalpa on 2/10/16.
 */

@RestController
public class AccountClientController {

    Logger logger = Logger.getLogger(AccountClientController.class.getName());

    @Autowired
    protected AccountClientService accountClientService;

    public AccountClientController(AccountClientService accountClientService) {
        this.accountClientService = accountClientService;
    }

    @RequestMapping(value = "/accounts/{accountNumber}" , method = RequestMethod.GET, produces = {"application/json"})
    public Account byNumber(Model model,
                           @PathVariable("accountNumber") String accountNumber) {

        logger.info("web-service byNumber() invoked: " + accountNumber);

        Account account = accountClientService.findAccountNumber(accountNumber);
        logger.info("web-service byNumber() found: " + account);
        //model.addAttribute("account", account);
        return account;
    }
}
