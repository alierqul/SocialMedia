package com.aliergul.socialmedia.graphql.mutation;

import com.aliergul.socialmedia.graphql.model.ProfileInput;
import com.aliergul.socialmedia.repository.IProfileReposity;
import com.aliergul.socialmedia.repository.entity.Profile;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Muttaion Resolver
 * İstenilen değerler ile kayıt,güncelleme ve silme işlemlerinde
 * kullanılmak üzere tasarlanmıştır.
 */

@Component
@RequiredArgsConstructor
public class ProfileMutationResolver implements GraphQLMutationResolver {

    private final IProfileReposity repository;

    public void createProfileElastic(ProfileInput profileInput){
        repository.save(Profile.builder()
                .country(profileInput.getCountry())
                .email(profileInput.getEmail())
                .firstname(profileInput.getFirstname())
                .lastname(profileInput.getLastname())
                .city(profileInput.getCity())
                .profileid(profileInput.getProfileid())
                .build());
    }
}