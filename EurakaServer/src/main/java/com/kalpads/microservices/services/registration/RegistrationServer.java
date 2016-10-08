package com.kalpads.microservices.services.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Registering the eureka server
 */
@SpringBootApplication(scanBasePackages = {"com.kalpads.controller"})
@EnableEurekaServer
public class RegistrationServer {

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(RegistrationServer.class, args);
    }
}
