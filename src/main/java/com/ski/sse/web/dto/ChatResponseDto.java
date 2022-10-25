package com.ski.sse.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@Data
public class ChatResponseDto {

    private String msg;
    private String sender;
    private String receiver;
    private Long roomNo;

}
