package com.aliergul.profile.controller;

import com.aliergul.profile.dto.request.ProfileRequestDto;
import static com.aliergul.profile.constant.RestApiUrl.*;
import com.aliergul.profile.repository.entity.Profile;
import com.aliergul.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VERSION+PROFILE)
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;

    @PostMapping(SAVE)
    public ResponseEntity<?> save(@RequestBody @Valid ProfileRequestDto dto){
        service.save(dto);
        return ResponseEntity.ok().body("Saved");
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Profile>> findALl(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
