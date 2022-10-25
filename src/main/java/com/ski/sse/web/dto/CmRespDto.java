package com.ski.sse.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmRespDto<T> {
    private int code;
    private String message;
    private T data;
}
