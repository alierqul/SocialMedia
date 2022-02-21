package com.aliergul.socialmedia.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class GlobalExceptionHandler {
    /**
     * 2- Yöntem var
     *  * Özelleştirilimiş bir hata mesajı gönderilmesi
     *  * TÜm servisler için ortak bir result objesi. Bunun içine hata kodu ve mesajlarını koyabiliriz.
     *
     */

    /**
     *   "AuthServiceException.class" tipinde hata gönderildiğinde bunu yakala.
     * @return
     */
    @ExceptionHandler(AuthServiceException.class)
    public ResponseEntity<ErrorMessage>  handlerAuthServiceException(AuthServiceException e){
        log.error(e.toString());
        return ResponseEntity.status(e.getErrorType().getHttpStatus())
                .body(ErrorMessage.builder()
                        .httpStatus(e.getErrorType().getHttpStatus())
                        .message(e.getErrorType().getMessage())
                        .code(e.getErrorType().getCode())
                        .build());
    }
}
