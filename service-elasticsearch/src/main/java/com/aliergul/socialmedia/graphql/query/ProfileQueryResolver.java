package com.aliergul.socialmedia.graphql.query;


import com.aliergul.socialmedia.repository.IProfileReposity;
import com.aliergul.socialmedia.repository.entity.Profile;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Query Resolver
 * Aldığı parametreler ile sorgulama yapmak için tasarlanmıştır.
 * Burada soru işlemlerini gerçekleştireceğiz.
 */

@Component
@RequiredArgsConstructor
public class ProfileQueryResolver implements GraphQLQueryResolver {

    private final IProfileReposity reposity;

    public List<Profile> findByFirstnameLike(String firstname){
        return reposity.findByFirstnameLike(firstname);
    }

    public Iterable<Profile> findAll(){
        return reposity.findAll();
    }
}
