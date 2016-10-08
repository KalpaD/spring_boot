package com.kalpads.microservices.client;

import com.kalpads.microservices.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by Kalpa on 2/10/16.
 */
@Service
public class AccountClientService {

    protected Logger logger = Logger.getLogger(AccountClientService.class.getName());

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;


    public AccountClientService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "https://" + serviceUrl;
    }


    @PostConstruct
    public void demo() {
        logger.warn("The rest template request factory is :" + restTemplate.getRequestFactory().getClass());
    }

    public Account findAccountNumber(String accountNumber) {
        logger.info("findByNumber() invoked: for " + accountNumber);
        return restTemplate.getForObject(serviceUrl + "/accounts/{accountNumber}",
                Account.class, accountNumber);
    }

}
