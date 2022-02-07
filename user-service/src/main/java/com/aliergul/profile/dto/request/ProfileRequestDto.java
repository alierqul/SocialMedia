package com.aliergul.profile.dto.request;

import com.aliergul.profile.repository.entity.Interest;
import com.aliergul.profile.repository.entity.Profile;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProfileRequestDto {
    long authid;
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
