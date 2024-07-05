package com.cashwu.javaspringbootcoffee;

import com.cashwu.javaspringbootcoffee.model.config.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JavaSpringBootCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootCoffeeApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "droid")
    Droid createDroid() {
        return new Droid();
    }
}
