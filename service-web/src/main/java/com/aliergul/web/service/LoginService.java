package com.aliergul.web.service;

import com.aliergul.web.dto.request.DoLoginDto;
import com.aliergul.web.dto.response.DoLoginResponseDto;
import com.aliergul.web.manager.AuthServiceManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthServiceManager authServiceManager;

    public LoginService(AuthServiceManager authServiceManager) {
        this.authServiceManager = authServiceManager;
    }

    public DoLoginResponseDto  Login(DoLoginDto dto) {

        return authServiceManager.doLogin(dto);
    }
}
