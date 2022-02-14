package com.aliergul.web.manager;

import static com.aliergul.web.constant.RestApiUrl.*;
import com.aliergul.web.dto.request.DoSignUpRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "localhost:8091"+VERSION+USER, name = "userServiceFeignClient", decode404 = true)
public interface AuthServiceManager {


    @PostMapping(DOSIGNUP)
    ResponseEntity<String> doSignUp(@RequestBody @Valid DoSignUpRequestDto user);
}
