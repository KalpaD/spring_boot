package com.kalpads.microservices.application;

import com.kalpads.microservices.client.AccountClientController;
import com.kalpads.microservices.client.AccountClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kalpa on 2/10/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) //Disable component scan
public class AccountServicesClientServer {

    /** URL uses the logical name of account-service - upper or lower case,
         doesn't matter.
     */
    public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";

    public static void main(String[] args) {
        // Tell server to look for web-server.properties or web-server.yml
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(AccountServicesClientServer.class, args);
    }

    /**
     * A customized RestTemplate that has the ribbon load balancer build in.
     * Note that prior to the "Brixton"
     *
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * The AccountService encapsulates the interaction with the micro-service.
     *
     * @return A new service instance.
     */
    @Bean
    public AccountClientService accountsService() {
        return new AccountClientService(ACCOUNTS_SERVICE_URL);
    }

    /**
     * Create the controller, passing it  to use.
     *
     * @return
     */
    @Bean
    public AccountClientController accountsController() {
        return new AccountClientController(accountsService());
    }
}
