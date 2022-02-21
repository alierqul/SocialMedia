package com.aliergul.socialmedia.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="tbluser")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "sq_tbluser_id",sequenceName = "sq_tbluser_id",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "sq_tbluser_id")
            // Bu bir sq oluşturur, büütün tablolarda yaı sürekli artar
            //@GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;
    /**
     *status kullanıcı aktiflik durumunu belirtir.
     * 0-> Pasif kullanıcı
     * 1-> aktif kullanıcı
     * 2-> engellenmiş kullanıcı, hesabı askıda
     * 3-> V.s
     */
    int status;
    long createDate;
    long updateDate;



}
