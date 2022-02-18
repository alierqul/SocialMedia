package com.aliergul.socialmedia.config.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Service
@Slf4j
public class JWTTokenFilter extends OncePerRequestFilter {
    @Autowired
      JwtTokenManager jwtTokenManager;
    @Autowired
      JwtUserDetail jwtUserDetail;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /**
         * Token ile gelen isteklerde, Authorization header'ını kontrol ediyoruz.
         * Burada "Bearer [Your token" şeklinde bir header gönderilmişse]
         */
        final String authorizationHeader=request.getHeader("Authorization");//Baarer Token

        /**
         * 1. Authorizon var mı yok mu?
         * 2. Bearer var mı yok mu?
         * 3. Kişi önceden oturum açmış mı?
         */
        if(authorizationHeader !=null
                && authorizationHeader.startsWith("Bearer ")
                && SecurityContextHolder.getContext().getAuthentication()==null
        ){
            /**
             * 7. karakterden sonrası bizim tokenimiz olucak.
             */
            final String token=authorizationHeader.substring(7);
            boolean isValid= jwtTokenManager.validateToken(token);
            if(isValid){
                Optional<String> profilID=jwtTokenManager.getProfileId(token);
                if(profilID.isPresent()){
                    UserDetails user=jwtUserDetail.loadUserProfileId(profilID.get());
                    if(user!=null){
                        log.warn("isOK= "+user);
                        /**
                         * Eğer Kullanıcı bilgileri doğru ise bize verilen spring oturum kullnaıcısının
                         * session oluşturarrark bu sessionun içine gömeriz.
                         */
                        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }

        }
        filterChain.doFilter(request,response);
    }
}
