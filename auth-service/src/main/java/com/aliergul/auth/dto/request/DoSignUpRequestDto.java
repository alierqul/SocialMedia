package com.aliergul.auth.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DoSignUpRequestDto {
    @NotNull
    @Size(min=2)
    String name;
    @NotNull
    @Size(min=2)
    String lastname;
    @Email
    @NotNull
    String username;
    @NotNull
    @Size(min=8,max=32)
    String password;
    int day;
    int month;
    int year;
    String gender;

}
