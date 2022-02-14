package com.aliergul.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean Login(String username, String password) {
        if (username.equals("admin@admin.com") && password.equals("admin12345")) {
            return true;
        }
        return false;
    }
}
