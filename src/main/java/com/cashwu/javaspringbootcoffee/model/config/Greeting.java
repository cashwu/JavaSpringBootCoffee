package com.cashwu.javaspringbootcoffee.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cash.wu
 * @since 2024/07/05
 */
@ConfigurationProperties(prefix = "greeting")
public class Greeting {

    private String name;
    private String coffee;

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
