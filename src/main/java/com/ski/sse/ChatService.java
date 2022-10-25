package com.ski.sse;

import com.ski.sse.domain.Chat;
import com.ski.sse.repository.ChatRepository;
import com.ski.sse.web.dto.ChatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatResponseDto setChat(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        chatRepository.save(chat);
        ChatResponseDto dto = ChatResponseDto.builder()
                .sender(chat.getSender())
                .receiver(chat.getReceiver())
                .msg(chat.getMsg())
                .build();
        return dto;
    }
}
