package com.aliergul.socialmedia.dto.request;

import com.aliergul.socialmedia.repository.entity.Interest;
import com.aliergul.socialmedia.repository.entity.Profile;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProfileRequestDto {
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
    Profile.Education education;
    Profile.Work work;


}
