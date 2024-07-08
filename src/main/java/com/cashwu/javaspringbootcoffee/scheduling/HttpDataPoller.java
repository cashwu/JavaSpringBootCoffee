package com.cashwu.javaspringbootcoffee.scheduling;

import com.cashwu.javaspringbootcoffee.model.Albums;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author cash.wu
 * @since 2024/07/08
 */
@EnableScheduling
@Component
public class HttpDataPoller {

    private final RedisConnectionFactory connectionFactory;
    private final RedisOperations<String, Albums> redisOperations;
    private WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/albums/3");

    public HttpDataPoller(RedisConnectionFactory connectionFactory,
                          RedisOperations<String, Albums> redisOperations) {
        this.connectionFactory = connectionFactory;
        this.redisOperations = redisOperations;
    }

    @Scheduled(fixedDelay = 3000)
    private void poll() {

//        connectionFactory.getClusterConnection().serverCommands().flushDb();

        System.out.println("--- start ---");

        webClient.get().retrieve().bodyToFlux(Albums.class)
                 //                .filter(a -> a.getId())
                 .toStream().forEach(ac -> redisOperations.opsForValue().set(ac.getId(), ac));

        redisOperations.opsForValue().getOperations().keys("*")
                       .forEach(a -> {
                           System.out.println("value ::");
                           System.out.println(redisOperations.opsForValue().get(a));
                       });

        System.out.println("--- end ---");
    }
}
