package com.aliergul.web.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("bilgeadam")){

            return new UserDetailsImpl("bilgeadam","123",new HashSet<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
