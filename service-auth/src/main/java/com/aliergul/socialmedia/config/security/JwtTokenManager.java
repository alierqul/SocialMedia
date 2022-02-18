package com.aliergul.socialmedia.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {
    @Value("${TOKEN_GENERATOR_KEY_SIGNATURE}")
    private String ALGORITHM;
    public Optional<String> createToken(String profilID){
        /**
         * Clain nesneleri, key-value şeklinde verileri iletmek için kullanılır.
         * withIssuer -> sahibi
         * withIssuedAt -> oluşturma zamanı
         * sign -> Gönderdiğimiz tokenin bir şekilde imzalanmalı.yani bu token bilgisinin bize ait olduğu anlaşılmalı
         * Bunu anlamak için özel bir parametre bir anahtar sözcük ile imzalamalıyız. Tahmini zor olmalı.
         */
        String token = JWT.create()
                .withAudience()
                .withClaim("profileID",profilID)
                .withIssuer("socialmedia.com")
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(ALGORITHM));
        return Optional.of(token);


    }
}
