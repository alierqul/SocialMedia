package com.aliergul.socialmedia.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
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
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60*60))//bir saat geçerli token
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(ALGORITHM));
        return Optional.of(token);


    }

    public Optional<String> getProfileId(String token){
        try {
            Optional<DecodedJWT> decodedJWT=getDecodeJWT(token);
            if (!decodedJWT.isPresent()) return Optional.empty();
            String profileId = decodedJWT.get().getClaim("profileID").asString();
            log.warn("profile id= "+profileId);
            return Optional.of(profileId);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public boolean validateToken(String token){
        try{

            Optional<DecodedJWT> decodedJWT=getDecodeJWT(token);
            log.warn("isOK= "+decodedJWT.isPresent());
            return decodedJWT.isPresent();
        }catch (Exception e){
            return false;
        }
    }

    public Optional<DecodedJWT> getDecodeJWT(String token){
        try{
            /**
             * Herhangi bir token in bizim imzamız ile doğrulanıp doğrulanmadığını öğrenmek için yazıyopruz.
             */
            JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(ALGORITHM))
                    .withIssuer(("socialmedia.com"))
                    .build();
            /**
             * Gelen Token in çözülmüş hali
             */
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            if(decodedJWT==null) return  Optional.empty();

            return Optional.of(decodedJWT);
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
