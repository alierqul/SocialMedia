package com.aliergul.socialmedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/fallback")
    ResponseEntity<String> fallback() {
        return ResponseEntity.internalServerError().body("Servis Bulunamad─▒. Daha Sonra Tekrar Deneyiniz....");
    }
}
