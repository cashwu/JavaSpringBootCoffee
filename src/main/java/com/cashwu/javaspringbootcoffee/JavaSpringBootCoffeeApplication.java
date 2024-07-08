package com.cashwu.javaspringbootcoffee;

import com.cashwu.javaspringbootcoffee.model.Albums;
import com.cashwu.javaspringbootcoffee.model.config.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

    @Bean
    public RedisOperations<String, Albums> redisOperations(RedisConnectionFactory factory) {

        Jackson2JsonRedisSerializer<Albums> serializer = new Jackson2JsonRedisSerializer<>(Albums.class);

        RedisTemplate<String, Albums> template = new RedisTemplate<>();

        template.setConnectionFactory(factory);
        template.setDefaultSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
}
