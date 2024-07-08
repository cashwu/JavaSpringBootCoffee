package com.cashwu.javaspringbootcoffee.scheduling;

import com.cashwu.javaspringbootcoffee.model.Albums;
import com.cashwu.javaspringbootcoffee.repository.AlbumsRepository;
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

//    private final RedisOperations<String, Albums> redisOperations;
    private final AlbumsRepository albumsRepository;
    private WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/albums/3");

    public HttpDataPoller(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @Scheduled(fixedDelay = 3000)
    private void poll() {

        System.out.println("--- start ---");

        webClient.get().retrieve().bodyToFlux(Albums.class)
                 .toStream().forEach(albumsRepository::save);

        albumsRepository.findAll().forEach(System.out::println);

        System.out.println("--- end ---");
    }
}
