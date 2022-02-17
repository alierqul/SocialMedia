package com.aliergul.socialmedia.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document
public class Profile {
    @Id
    String id;
    long authid;
    String token;
    String firstname;
    String lastname;
    String email;
    String birthday;
    String country;
    String city;
    String gender;
    String about;
    List<Interest> interestList;
    Education education;
    Work work;

    @Document
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Education implements Serializable {
        String name;
        int from;
        int to;
        String about;
    }
    @Document
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Work implements Serializable {
        String company;
        String designation;
        int from;
        int to;
    }


}
