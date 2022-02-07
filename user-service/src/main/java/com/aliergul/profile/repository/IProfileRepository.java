package com.aliergul.profile.repository;

import com.aliergul.profile.repository.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileRepository extends MongoRepository<Profile,String> {
    Optional<Profile> findByAuthid (long id);

}
