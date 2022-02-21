package com.aliergul.socialmedia.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@ToString
public enum ErrorType {
    AUTH_NOT_LOGIN_EMAIL_AND_PASSWORD(1902,"Kullanıcı adı veya şifre hatalı",HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN_INFO(1904,"Geçersiz Token Bilgisi",HttpStatus.UNAUTHORIZED),
    AUTH_AN_UNEXPECTED_ERROR(1903,"Beklenmeyen bir hata oluştu",HttpStatus.INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    private HttpStatus httpStatus;

    ErrorType(int i, String s, HttpStatus unauthorized) {
    }
}
