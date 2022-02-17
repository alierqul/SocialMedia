package com.aliergul.web.config;


import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MVCTokenFilter mvcTokenFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /**
         * Restapi izinlere takılmadan kullanmak için etkinkeştirilir.
         * Web, csrf etkin kalmalı.
         */
        http.csrf().disable();
        /**
         * Http isteklerinde kimliklendirme işlemlerine takılmış isteklerin tamamında
         * izinleri sorgulama
         */
//        http.authorizeRequests().anyRequest().permitAll();
        /**
         * Bu orjinal configürasyonda olan komutlar, tüm istekler login e yönlendir.
         */
        /**
         * Bu kısım orjinal komut kısmımız.
         * Form ile kullanıcıyı yetkilendirmek üzere bir web sayfasına yönlendirir.
         * httpbasic ile kullanıcıdan bilgi girişi yapması için ilgili browser ın
         * tasarımına yönlendireceğiz
         */
        /**
         * http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
         *         http.formLogin();
         *         http.httpBasic();
         */
        http.authorizeRequests()
                /**
                 * http://localhost/register adresine gitmek konusunda izni var                 * ancak diğer tüm isteklerde izne tabii tutuluyor.
                 */
                .antMatchers("/signup","/login").permitAll()
                .anyRequest().authenticated();
        /**
         * Eğer özellikle belirtilmemiş ise login formu spring tarafından sağlanır ve yönetilir.
         */
//        http.formLogin();
        /**
         * Artık yetkisiz alanlara girişte kendi tanımladığımız formu kullanır.
         */
        http.formLogin().loginPage("/login").loginProcessingUrl("/login");
        /**
         * Bir isteği Spring filter ve servlet filter işleme tabi tutar.
         * Biz burada araya girerek, kendi kullanıcımızı springe tanıtmalıyız.
         */
        http.addFilterBefore(mvcTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}