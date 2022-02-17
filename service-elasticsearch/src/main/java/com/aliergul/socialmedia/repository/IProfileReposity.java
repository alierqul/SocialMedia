package com.aliergul.socialmedia.repository;

import com.aliergul.socialmedia.repository.entity.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfileReposity  extends ElasticsearchRepository<Profile, String> {
    /**
     * KUllanıcı ilk adına göre arama yapar. aynı zamanda arama işlemini A* şeklinde yapacaktır.
     * @param firstname
     * @return
     */
    List<Profile> findByFirstnameLike(String firstname);
}
