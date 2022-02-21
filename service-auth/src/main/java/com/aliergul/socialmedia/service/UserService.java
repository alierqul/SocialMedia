package com.aliergul.socialmedia.service;

import com.aliergul.socialmedia.config.security.JwtTokenManager;
import com.aliergul.socialmedia.dto.request.DoSignUpRequestDto;
import com.aliergul.socialmedia.dto.response.DoLoginResponseDto;
import com.aliergul.socialmedia.dto.request.DoLoginRequestDto;
import com.aliergul.socialmedia.dto.request.FindByAutIdDto;
import com.aliergul.socialmedia.exception.AuthServiceException;
import com.aliergul.socialmedia.exception.ErrorType;
import com.aliergul.socialmedia.manager.ProfileManager;
import com.aliergul.socialmedia.mapper.IUserMapper;
import com.aliergul.socialmedia.repository.IUserRepository;
import com.aliergul.socialmedia.repository.entity.User;
import com.aliergul.socialmedia.utilty.JwtEncodeDecode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository iUserRepository;
    private final IUserMapper mapper;
    private final ProfileManager profileManager;
    private final JwtTokenManager jwtTokenManager;
    private final JwtEncodeDecode jwtEncodeDecode;
    private final CacheManager cacheManager;



    /**
     * Kullanıcıyı PostgreSQL database e yazar
     * @param user
     * @return
     */
    public User saveReturnUser(DoSignUpRequestDto user){
        return iUserRepository.save(mapper.toUser(user));
    }

    public User update(User user){


        return null;
    }
    public void delete(String username){
        iUserRepository.delete(findUsername(username));
    }
    @Cacheable(value = "user_test_cache_findall")
    public List<User> findall(){
        return iUserRepository.findAll();
    }

    public void findAllTestCacheClear(){
        cacheManager.getCache("user_test_cache_findall").clear();
        log.warn("Cache <user_test_cache_findall> temizlendi.");
    }


    public User findUsername(String username){
        Optional<User> inDB=iUserRepository.findByUsername(username);
        if(!inDB.isPresent()){
            throw new IllegalArgumentException("Email Bulunamadı");
        }

        return inDB.get();
    }

    public boolean verifyToke(String token){
        return jwtTokenManager.validateToken(token);
    }

    @Cacheable(value = "redisMessage")
    public String redisMessage(String message){
        try{
            /**
             * Cashlenmeyen mesaj ise 3 sn bekliyecek.
             * Cashlenmiş ise beklemeden Cevabı dönecek.
             */
            Thread.sleep(3000);
        }catch(Exception e){}

        return message;
    }

    public DoLoginResponseDto loginUsernameAndPassword(DoLoginRequestDto dto){
        Optional<User> inDB=iUserRepository.findByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(!inDB.isPresent()){
            return DoLoginResponseDto.builder().error(410).build();
        }else{
            log.info("USER = "+inDB.get());
            String profilID=profileManager.findByAuthId(FindByAutIdDto.builder().authid(inDB.get().getId()).build());
            if(profilID==null || profilID.isEmpty()){

                throw new AuthServiceException(ErrorType.AUTH_NOT_LOGIN_EMAIL_AND_PASSWORD,"Profile id bilgisi alınamadı.");
            }else{
                log.warn("User PROFIL ID= "+profilID);
                log.warn("User PROFIL ID= "+jwtEncodeDecode.getEncryptUUID(profilID));
                Optional<String> token= jwtTokenManager.createToken(profilID);
                DoLoginResponseDto response;
                if(token.isPresent()){
                    response= DoLoginResponseDto.builder().status(200).id(profilID).token(token.get()).error(200).build();
                }else{
                    throw new AuthServiceException(ErrorType.INVALID_TOKEN_INFO,"Geçersiz Token");

                }
                return response;


            }
        }

    }

}
