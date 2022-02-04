package com.aliergul.auth.service;

import com.aliergul.auth.dto.request.DoLoginRequestDto;
import com.aliergul.auth.repository.IUserRepository;
import com.aliergul.auth.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final
    IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * Kullanıcıyı PostgreSQL database e yazar
     * @param user
     * @return
     */
    public User saveReturnUser(User user){
        return iUserRepository.save(user);
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

    public User loginUsernameAndPassword(User dto){
        Optional<User> inDB=iUserRepository.findByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(!inDB.isPresent()){
            throw new IllegalArgumentException("Email ya da şifre hatalı");
        }
        return inDB.get();
    }

    public User findUsername(String username){
        Optional<User> inDB=iUserRepository.findByUsername(username);
        if(!inDB.isPresent()){
            throw new IllegalArgumentException("Email Bulunamadı");
        }
        return inDB.get();
    }

}
