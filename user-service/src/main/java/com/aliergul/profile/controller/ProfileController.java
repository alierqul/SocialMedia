package com.aliergul.profile.controller;

import com.aliergul.profile.dto.request.FindByAutIdDto;
import com.aliergul.profile.dto.request.ProfileRequestDto;
import static com.aliergul.profile.constant.RestApiUrl.*;
import com.aliergul.profile.repository.entity.Profile;
import com.aliergul.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(VERSION+PROFILE)
@RequiredArgsConstructor
@Slf4j
public class ProfileController {
    private final ProfileService service;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("Merhaba Dünya- Profile Service");
    }
    @PostMapping(SAVE)
    ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){
        String profileId= service.save(dto).getId();
        return ResponseEntity.ok().body(profileId);
    }
    @PostMapping(FIND_BY_AUTH_ID)
    String findByAuthId(@RequestBody FindByAutIdDto auth){
        log.info("İstek Geldi : \nid: " +  auth);
        Optional<Profile> profile = service.findByAuth(auth.getAuthid());
        if(profile.isPresent()){
            log.info("İstek Geldi : \nprofile: " +  profile.get());
            return profile.get().getId();
        }else{
            log.info("Sayfa bulunamadı: 500 ");
            return "500";
        }
    }

    @GetMapping(GETALL)
     ResponseEntity<List<Profile>> findALl(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
