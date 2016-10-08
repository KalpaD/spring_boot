package com.kalpads.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Run this application as micro service
 *
 * Register with eureka
 */
@EnableAutoConfiguration //defines this as a Spring Boot application.
@EnableDiscoveryClient   //this enables service registration and discovery.
@ComponentScan(basePackages = "com.kalpads.services.controller")
public class AccountsServer
{
    public static void main(String[] args) {
        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}
