package com.aliergul.socialmedia.config;


import com.aliergul.socialmedia.dto.request.DoLoginDto;
import com.aliergul.socialmedia.dto.response.DoLoginResponseDto;
import com.aliergul.socialmedia.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class MVCTokenFilter extends OncePerRequestFilter {

    final LoginService service;
    final UserDetailsServiceImpl userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Object username=request.getParameter("username");
        Object password=request.getParameter("password");

        if(username!=null && password !=null){
            log.info("username : " +username);
            log.info("password : " +password);
            DoLoginResponseDto responseDto=service.Login(DoLoginDto.builder().username(username.toString()).password(password.toString()).build());
            log.info("response : " +responseDto);
            if(responseDto.getError()==200){
                log.info("response  isOK" );
                UserDetailsImpl userDetails = (UserDetailsImpl) userDetailService.loadUserByUsername("bilgeadam");
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails
                                ,null,userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request,response);
    }
}
