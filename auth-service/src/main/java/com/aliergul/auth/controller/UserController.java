package com.aliergul.auth.controller;

import com.aliergul.auth.dto.request.DoLoginRequestDto;
import com.aliergul.auth.dto.request.DoSignUpRequestDto;
import com.aliergul.auth.mapper.IUserMapper;
import com.aliergul.auth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/doLogin")
    @Operation(summary = "Kullanıcı girişi için kullanılacak metod")
    public ResponseEntity<?> doLogin(@RequestBody @Valid DoLoginRequestDto user){

        return ResponseEntity.ok().body(service.loginUsernameAndPassword(user));
    }

    @PostMapping("/doSignUp")
    public ResponseEntity<?> doSignUp(@RequestBody @Valid DoSignUpRequestDto user){
        // 1. Etapta -> auth için kayıt olmalı
        service.saveReturnUser(user);

        // 2. Etapta-> User-service e kayıt için istek atmalı, dönen cevaba göre işlem yapılmalı
        return ResponseEntity.ok().body("Saved");
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(service.findall());
    }
}
