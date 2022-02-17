package com.aliergul.socialmedia.repository;

import com.aliergul.socialmedia.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    /**
     * Kullanıcı oturum açabilmesi için email ve şifre bilgisi alınır.
     * Kayıtlı bilgi var ise optional olarak cevap döner.
     * @param username : Email Bilgisi
     * @param password : Şifre Bilgisi
     * @return
     */
    Optional<User> findByUsernameAndPassword(String username,String password);

    /**
     * Durumlarına göre kullanıcıları listeler.
     * @param status
     * @return
     */
    List<User> findByStatus(int status);

    Optional<User> findByUsername(String username);
}
