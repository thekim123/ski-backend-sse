package com.ski.sse.repository;

import com.ski.sse.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable
    @Query("{roomNo:  ?0}")
    Flux<Chat> findByRoomNo(long roomNo);

}
