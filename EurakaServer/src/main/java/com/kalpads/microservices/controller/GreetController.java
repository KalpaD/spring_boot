package com.kalpads.microservices.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kalpa on 11/9/16.
 */
@RestController
public class GreetController {

    @RequestMapping("/")
    public String greet() {

        return "Hello, World!!";
    }
}
