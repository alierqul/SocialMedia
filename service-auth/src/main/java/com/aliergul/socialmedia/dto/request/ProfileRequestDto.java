package com.aliergul.socialmedia.dto.request;

import lombok.*;

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



}
