package com.aliergul.web.manager;

import static com.aliergul.web.constant.RestApiUrl.*;

import com.aliergul.web.dto.request.DoLoginDto;
import com.aliergul.web.dto.request.DoSignUpRequestDto;
import com.aliergul.web.dto.response.DoLoginResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "localhost:8091"+VERSION+AUTH, name = "userServiceFeignClient", decode404 = true)
public interface AuthServiceManager {


    @PostMapping(DOSIGNUP)
    String doSignUp(@RequestBody @Valid DoSignUpRequestDto user);
    @PostMapping(DOLOGIN)
    DoLoginResponseDto doLogin(@RequestBody @Valid DoLoginDto user);
}
