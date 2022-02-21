package com.aliergul.socialmedia.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorMessage {
    private int code;
    private String message;
    private HttpStatus httpStatus;


}
