package com.aliergul.socialmedia.config.security;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AuthServiceSecurity  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * İstek atılmasına izin vereceğimiz mapperlar
         * swagger-ui
         * dologin
         * dosignup
         */
        http.authorizeRequests().antMatchers("/v3/api-docs/**"
                                                    ,"/swagger-ui/**"
                                                    ,"/v1/auth/dologin"
                                                    ,"/v1/auth/dosignup"
                                                    ,"/v1/auth/findall").permitAll()
        .anyRequest().authenticated()

                .and().csrf().disable();
    }
}
