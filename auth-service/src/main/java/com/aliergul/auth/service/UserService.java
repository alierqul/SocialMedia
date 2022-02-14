package com.aliergul.auth.service;

import com.aliergul.auth.dto.request.DoLoginRequestDto;
import com.aliergul.auth.dto.request.DoSignUpRequestDto;
import com.aliergul.auth.dto.response.DoLoginResponseDto;
import com.aliergul.auth.manager.ProfileManager;
import com.aliergul.auth.mapper.IUserMapper;
import com.aliergul.auth.repository.IUserRepository;
import com.aliergul.auth.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final IUserRepository iUserRepository;
    final IUserMapper mapper;
    final ProfileManager profileManager;

    public UserService(IUserRepository iUserRepository, IUserMapper mapper, ProfileManager profileManager) {
        this.iUserRepository = iUserRepository;
        this.mapper=mapper;
        this.profileManager = profileManager;
    }

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
    public List<User> findall(){
        return iUserRepository.findAll();
    }



    public User findUsername(String username){
        Optional<User> inDB=iUserRepository.findByUsername(username);
        if(!inDB.isPresent()){
            throw new IllegalArgumentException("Email Bulunamadı");
        }

        return inDB.get();
    }

    public DoLoginResponseDto loginUsernameAndPassword(DoLoginRequestDto dto){
        Optional<User> inDB=iUserRepository.findByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(!inDB.isPresent()){
            return DoLoginResponseDto.builder().error(410).build();
        }
        String profilID=profileManager.findByAuthId(inDB.get().getId()).getBody();
        if(profilID==null || profilID.isEmpty()){
            return DoLoginResponseDto.builder().error(500).build();
        }else{
            return DoLoginResponseDto.builder().status(inDB.get().getStatus()).id(profilID).build();
        }

    }

}
