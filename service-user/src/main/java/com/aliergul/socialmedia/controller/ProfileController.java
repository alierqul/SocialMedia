package com.aliergul.socialmedia.controller;

import com.aliergul.socialmedia.dto.request.FindByProfileIDDto;
import com.aliergul.socialmedia.rabbitmq.model.ProfileNotification;
import com.aliergul.socialmedia.rabbitmq.producer.ElasticProfileProducer;
import com.aliergul.socialmedia.service.ProfileService;
import com.aliergul.socialmedia.dto.request.FindByAutIdDto;
import com.aliergul.socialmedia.dto.request.ProfileRequestDto;
import static com.aliergul.socialmedia.constant.RestApiUrl.*;
import com.aliergul.socialmedia.repository.entity.Profile;
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
    private final ElasticProfileProducer elasticProfileProducer;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){
        String id = service.save(dto).getId();
        elasticProfileProducer.sendMessageProfileSave(ProfileNotification.builder()
                .city(dto.getCity())
                .country(dto.getCountry())
                .email(dto.getEmail())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .profileid(id)
                .build());
        return ResponseEntity.ok(id);
    }
    @PostMapping(FIND_BY_AUTH_ID)
    String findByAuthId(@RequestBody FindByAutIdDto auth){
        Optional<Profile> profile = service.findByAuth(auth.getAuthid());
        if(profile.isPresent()){
            return profile.get().getId();
        }else{
            return "500";
        }
    }
    @PostMapping(IS_PROFILE_EXIST_BY_PROFILE_ID)
    ResponseEntity<Boolean> isByProfileId(@RequestBody FindByProfileIDDto dto){
        return ResponseEntity.ok(service.findById(dto.getProfileID()).isPresent());
    }

    @GetMapping(GETALL)
     ResponseEntity<List<Profile>> findALl(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
