package com.msa4spring.responses;

import lombok.*;

@Getter
@Builder
public class ResponseDTO<T> {
    private String code;
    private String msg;
    private T data;
}
