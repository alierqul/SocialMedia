package com.aliergul.auth.controller;
import static com.aliergul.auth.constant.RestApiUrl.*;
import com.aliergul.auth.dto.request.DoLoginRequestDto;
import com.aliergul.auth.dto.request.DoSignUpRequestDto;
import com.aliergul.auth.dto.request.ProfileRequestDto;
import com.aliergul.auth.manager.ProfileManager;
import com.aliergul.auth.repository.entity.User;
import com.aliergul.auth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(VERSION+USER)
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;
    private final ProfileManager profileManager;



    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("Merhaba Dünya- Auth Service");
    }
    @PostMapping(DOLOGIN)
    @Operation(summary = "Kullanıcı girişi için kullanılacak metod")
    public ResponseEntity<?> doLogin(@RequestBody @Valid DoLoginRequestDto user){

        return ResponseEntity.ok().body(service.loginUsernameAndPassword(user));
    }

    @PostMapping(DOSIGNUP)
    public ResponseEntity<String> doSignUp(@RequestBody @Valid DoSignUpRequestDto user){
        log.info("İstek Geldi : \n:" +  user);
        // 1. Etapta -> auth için kayıt olmalı
        User inDB=service.saveReturnUser(user);
        log.info("PostgreSQL kaydedildi." );
        // 2. Etapta-> User-service e kayıt için istek atmalı, dönen cevaba göre işlem yapılmalı
        String profileId =  profileManager.save(ProfileRequestDto.builder()
                        .authid(inDB.getId())
                        .email(inDB.getUsername())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .country(user.getCountry())
                        .city(user.getCity())
                        .gender(user.getGender())
                .build()).getBody();
        log.info("MongoDB kaydedildi." );
        return ResponseEntity.ok().body(profileId);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(service.findall());
    }
}
