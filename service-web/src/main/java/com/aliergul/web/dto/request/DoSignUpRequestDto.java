package com.aliergul.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoSignUpRequestDto {

    @NotNull
    @Size(min = 2)
    String firstname;
    @NotNull
    @Size(min = 2)
    String lastname;
    @Email
    @NotNull
    String username;
    @NotNull
    @Size(min = 8,max = 32)
    String password;
    String image;
    int day;
    int month;
    int year;
    String country;
    String city;
    String gender;


}
