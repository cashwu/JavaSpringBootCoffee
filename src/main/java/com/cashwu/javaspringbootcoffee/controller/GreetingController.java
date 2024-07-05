package com.cashwu.javaspringbootcoffee.controller;

import com.cashwu.javaspringbootcoffee.model.config.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cash.wu
 * @since 2024/07/05
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

//    @Value("${greeting-name: Mirage}")
//    private String name;
//
//    @Value("${greeting-coffee: ${greeting-name} is drinking cafe}")
//    private String coffee;

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    String getGreeting() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    String getNameAndCoffee() {
        return greeting.getCoffee();
    }


}
