package com.aliergul.socialmedia.service;

import com.aliergul.socialmedia.dto.request.ProfileRequestDto;
import com.aliergul.socialmedia.mapper.ProfileMapper;
import com.aliergul.socialmedia.repository.IProfileRepository;
import com.aliergul.socialmedia.repository.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final IProfileRepository repository;
    private final ProfileMapper mapper;
    public Profile save(ProfileRequestDto profile){
        return repository.save(mapper.toProfile(profile));
    }

    public void update(Profile profile){
        repository.save(profile);
    }

    public void delete(Profile profile){
        repository.delete(profile);
    }

    public List<Profile> findAll(){
        return repository.findAll();
    }

    public Optional<Profile> findByAuth(long id){
        return repository.findByAuthid(id);

    }

    public Optional<Profile> findById(String id){
        return repository.findById(id);

    }

}
