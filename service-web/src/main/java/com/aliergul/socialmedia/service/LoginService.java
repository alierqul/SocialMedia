package com.aliergul.socialmedia.service;

import com.aliergul.socialmedia.dto.response.DoLoginResponseDto;
import com.aliergul.socialmedia.manager.AuthServiceManager;
import com.aliergul.socialmedia.dto.request.DoLoginDto;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthServiceManager authServiceManager;

    public LoginService(AuthServiceManager authServiceManager) {
        this.authServiceManager = authServiceManager;
    }

    public DoLoginResponseDto Login(DoLoginDto dto) {

        return authServiceManager.doLogin(dto);
    }
}
