package com.aliergul.socialmedia.config.security;

import com.aliergul.socialmedia.dto.request.FindByProfileIDDto;
import com.aliergul.socialmedia.manager.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetail implements UserDetailsService {
    @Autowired
    private ProfileManager profileManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserProfileId(String profileId){
        boolean isprofile = profileManager.isByProfileId(FindByProfileIDDto.builder().profileID(profileId).build()).getBody();
        if(isprofile){
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
            return new User(profileId, "", true,
                    true, true, true, grantedAuthorities);
        }
        return null;
    }
}
