package com.ski.sse.web;

import com.ski.sse.ChatService;
import com.ski.sse.domain.Chat;
import com.ski.sse.repository.ChatRepository;
import com.ski.sse.web.dto.ChatResponseDto;
import com.ski.sse.web.dto.CmRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatRepository chatRepository;

    @PostMapping("/save")
    public Mono<Chat> setMsg(@RequestBody Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    @GetMapping(value = "chat/roomNo/{roomNo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> findByRoomNo(@PathVariable Long roomNo) {
        return chatRepository.findByRoomNo(roomNo).subscribeOn(Schedulers.boundedElastic());
    }
}
