package com.ski.sse.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chat")
public class Chat {
    private String id;
    private String msg;
    private String sender;
    private String receiver;
    private Long roomNo;

    private LocalDateTime createdAt;
}
